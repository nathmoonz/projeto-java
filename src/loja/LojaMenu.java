package loja;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import ecommerce.controller.CarrinhoController;
import ecommerce.controller.Catalogo;
import ecommerce.model.Produto;

public class LojaMenu {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		int opcao = 0;
		boolean menu = true;
		Catalogo catalogo = new Catalogo();
		CarrinhoController carrinho = new CarrinhoController();
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

		while (menu) {

			System.out.println("                                                     ");
			System.out.println("                       LOJITA                        ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Listar Produtos                      ");
			System.out.println("            2 - Adicionar Produtos no Carrinho       ");
			System.out.println("            3 - Visualizar Carrinho                  ");
			System.out.println("            4 - Finalizar Compra                     ");
			System.out.println("            5 - Sair                                 ");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1:
				System.out.println("");
				catalogo.visualizarItensCatalogo();
				keyPress();
				break;
			case 2:

				System.out.print("Digite o ID do produto que deseja adicionar ao carrinho: ");
				int idProduto = leia.nextInt();

				try {
					Produto produto = catalogo.listaProdutos.get(idProduto);
					String precoFormatado = decimalFormat.format(produto.getPreco());
					boolean sair = false;
					while (!sair) {
						System.out.println("---------------------------------");
						System.out.println("Nome: " + produto.getNome());
						System.out.println("Preço: R$ " + precoFormatado);
						System.out.println("Quantidade em estoque: " + produto.getQuantidade());
						System.out.println("---------------------------------");
						System.out.println("Insira a quantidade desejada: ");

						int quantidade = leia.nextInt();
						if (quantidade > produto.getQuantidade()) {
							System.out.println("Quantidade em estoque insuficiente");
						} else {
							carrinho.adicionarProduto(produto, quantidade);
							sair = true;
						}
					}

				} catch (Exception e) {
					System.out.println("Produto não encotrado!");
				}

				keyPress();
				break;
			case 3:
				carrinho.exibirCarrinho();
				keyPress();
				break;
			case 4:
				carrinho.finalizarCompra();
				keyPress();
				break;
			case 5:
				System.out.println("Você saiu da Lojita =)");
				menu = false;
				System.exit(0);
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}

	}

}
