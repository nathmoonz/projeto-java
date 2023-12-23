package ecommerce.model;

public abstract class Produto {
	private int id;
	public String nome;
	public double preco;
	public int quantidade;

	public Produto(int id, String nome, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void decrementarQuantidade(int quantidade) throws Exception {
		if (this.quantidade < quantidade) {
			throw new Exception("Produto Insuficiente, altere a quantidade");
		} 
		this.quantidade -= quantidade;
	}

}
