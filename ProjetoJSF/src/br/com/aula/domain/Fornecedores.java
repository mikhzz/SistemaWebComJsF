package br.com.aula.domain;

public class Fornecedores {

	private int idFornecedores;
	private String descricao;

	public Fornecedores() {
		super();

	}

	public Fornecedores(int idFornecedores, String descricao) {
		super();
		this.idFornecedores = idFornecedores;
		this.descricao = descricao;
	}

	public int getIdFornecedores() {
		return idFornecedores;
	}

	public void setIdFornecedores(int idFornecedores) {
		this.idFornecedores = idFornecedores;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String saida = idFornecedores + " - " + descricao;

		return saida;
	}

}
