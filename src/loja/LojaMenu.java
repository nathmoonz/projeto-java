package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class LojaMenu {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		int opcao = 0;
		boolean menu = true;

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
				keyPress();
				break;
			case 2:
				System.out.println("");
				keyPress();
				break;
			case 3:
				// visualizar carrinho
				System.out.println("");
				keyPress();
				break;
			case 4:
				// Mostrar valor final e produtos selecionados
				System.out.println("");
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
