package br.com.aula.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.domain.Fornecedores;
import br.com.aula.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;
	private Fornecedores fornecedor;

	public Fornecedores getFornecedores() {
		return fornecedor;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedor = fornecedores;
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}

	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO dao = new FornecedoresDAO();

			itens = dao.listar();
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
		}
	}

	public void prepararNovo() {
		fornecedor = new Fornecedores();
	}

	public void novo() {

		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			dao.salvar(fornecedor);

			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor Salvo Com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void excluir() {

		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			dao.excluir(fornecedor);

			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor Excluido Com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possivel excluir um fornecedor com produto associado a ele");
			e.printStackTrace();
		}

	}

	public void editar() {

		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			dao.editar(fornecedor);

			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fornecedor Editado Com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possivel Editar o Fornecedor");
			e.printStackTrace();

		}

	}

}
