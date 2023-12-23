package ecommerce.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ecommerce.model.Produto;
import ecommerce.model.ProdutoCarrinho;
import ecommerce.repository.ICarrinhoRepository;

public class CarrinhoController implements ICarrinhoRepository {

	HashMap<Integer, ProdutoCarrinho> carrinho = new HashMap<Integer, ProdutoCarrinho>();

	@Override
	public void adicionarProduto(Produto produto, int quantidade) {
		try {
			ProdutoCarrinho novoProduto;
			if (carrinho.containsKey(produto.getId())) {
				novoProduto = carrinho.get(produto.getId());
				novoProduto.quantidade += quantidade;
			} else {
				novoProduto = new ProdutoCarrinho(produto, quantidade);
			}
			this.carrinho.put(produto.getId(), novoProduto);
			produto.decrementarQuantidade(quantidade);

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

	@Override
	public void limparCarrinho() {
		carrinho.clear();

	}

	@Override
	public void finalizarCompra() {
		System.out.println("*********** COMPRA REALIZADA COM SUCESSO! ***********");
		System.out.println("Comprovante de pagamento: ");
		this.exibirCarrinho();
		this.limparCarrinho();

	}

	@Override
	public void exibirCarrinho() {
		double precoTotalCarrinho = 0;
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		System.out.println(" ************************************* ");
		System.out.println("");
		for (ProdutoCarrinho item : this.carrinho.values()) {
			double preco = item.produto.getPreco() * item.quantidade;
			precoTotalCarrinho += preco;
			String precoFormatado = decimalFormat.format(preco);
			System.out.println("     ID: " + item.produto.getId() + "  Nome: " + item.produto.getNome()
					+ "  -  Preço TOTAL: R$ " + precoFormatado + "     Quantidade: " + item.quantidade);

		}
		String precoCarrinhoFormatado = decimalFormat.format(precoTotalCarrinho);
		System.out.println("     Preço TOTAL: R$ " + precoCarrinhoFormatado + "\n");
		System.out.println("");
		System.out.println(" ************************************* ");

	}

}
