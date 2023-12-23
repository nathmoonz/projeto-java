package ecommerce.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ecommerce.model.Produto;
import ecommerce.model.ProdutosEletroDomesticos;
import ecommerce.model.ProdutosEletronicos;
import ecommerce.repository.ICatalogoRepository;

public class Catalogo implements ICatalogoRepository {

	public Catalogo() {
		this.instanciarProdutos();
	}

	public ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	private int id = 0;

	@Override
	public void visualizarItensCatalogo() {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		System.out.println(" ************************************* ");
		System.out.println("");
		for (Produto produto : listaProdutos) {
			String precoFormatado = decimalFormat.format(produto.getPreco());
			System.out.println("     ID: " + produto.getId() + "  Nome: " + produto.getNome() + "  -  Preço: R$ "
					+ precoFormatado + "      Estoque: " + produto.getQuantidade());

		}
		System.out.println("");
		System.out.println(" ************************************* ");
	}

	@Override
	public void instanciarProdutos() {
		listaProdutos.add(new ProdutosEletronicos(gerarId(), "WebCam Logitech c920", 429.99, 50));
		listaProdutos.add(new ProdutosEletronicos(gerarId(), "Console PlayStation 5 Sony", 4189.99, 20));
		listaProdutos.add(new ProdutosEletronicos(gerarId(), "Controle Sony DualSense PS5", 419.99, 30));
		listaProdutos.add(new ProdutosEletronicos(gerarId(), "Console Nitendo Switch", 2189.99, 30));
		listaProdutos.add(new ProdutosEletronicos(gerarId(), "HeadSet sem fio Sony", 474.99, 2));
		listaProdutos.add(new ProdutosEletroDomesticos(gerarId(), "Micro-Ondas Electrolux", 599.90, 5));
		listaProdutos.add(new ProdutosEletroDomesticos(gerarId(), "Frigobar Brastemp Retrô", 1999.90, 10));
		listaProdutos.add(new ProdutosEletroDomesticos(gerarId(), "Purificador de Água Pure 4x", 519.90, 8));
		listaProdutos.add(new ProdutosEletroDomesticos(gerarId(), "Cervejeira MetalFrio", 5668.20, 8));

	}

	@Override
	public int gerarId() {
		return id++;
	}

}
