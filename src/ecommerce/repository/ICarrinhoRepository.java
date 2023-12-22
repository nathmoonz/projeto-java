package ecommerce.repository;

import ecommerce.model.Produto;

public interface ICarrinhoRepository {
	public void adicionarProdutoCarrinho(Produto produto, int quantidade);

	public void removerProduto(Produto produto);

	public void atualizarQuantidade(Produto produto, int novaQuantidade);

	public void limparCarrinho();

	// --------------
	public double calcularTotal();

	public void finalizarCompra();

	public void exibirCarrinho();

}
