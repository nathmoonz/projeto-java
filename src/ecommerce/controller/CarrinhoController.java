package ecommerce.controller;

import ecommerce.model.Produto;
import ecommerce.repository.ICarrinhoRepository;

public class CarrinhoController implements ICarrinhoRepository{

	@Override
	public void adicionarProdutoCarrinho(Produto produto, int quantidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarQuantidade(Produto produto, int novaQuantidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limparCarrinho() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void finalizarCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibirCarrinho() {
		// TODO Auto-generated method stub
		
	}
	
}
