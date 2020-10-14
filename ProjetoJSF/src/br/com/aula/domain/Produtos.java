package br.com.aula.domain;

public class Produtos {
	
	
	private int idProdutos;
	private String descricao;
	private int quantidade;
	private double preco;
	private Fornecedores fornecedor = new Fornecedores();

	public Produtos() {
		super();
		
	}

	public Produtos(int idProdutos, String descricao, int quantidade, double preco, Fornecedores fornecedor) {
		super();
		this.idProdutos = idProdutos;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedor = fornecedor;
	}

	public int getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(int idProdutos) {
		this.idProdutos = idProdutos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Fornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		String saida = idProdutos + " - " + descricao + " - " + preco + " - " + quantidade + " - " + fornecedor.getDescricao();
		return saida;
	}

	
	
	
	
	
	
}
