package ecommerce.model;

public class ProdutoCarrinho {
	public Produto produto;
	public int quantidade;

	public ProdutoCarrinho(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

}
