package ecommerce.repository;

import ecommerce.model.Produto;

public interface ICarrinhoRepository {
	public void adicionarProduto(Produto produto, int quantidade);

	public void limparCarrinho();

	public void finalizarCompra();

	public void exibirCarrinho();

}
