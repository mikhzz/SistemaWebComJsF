package br.com.aula.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.DAO.ProdutoDAO;
import br.com.aula.domain.Fornecedores;
import br.com.aula.domain.Produtos;
import br.com.aula.util.JSFUtil;


@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {

	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;
	private Produtos produtos;
    private ArrayList<Fornecedores> comboFornecedores;
	
	
	
	
	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	
	
	
	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutoDAO dao = new ProdutoDAO();

			itens = dao.listar();
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
		}
	}

	public void prepararNovo() {
		produtos = new Produtos();
		
		
		
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void novo() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produtos);
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Produto Salvo Com Sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemSucesso("ex.getMessage()");

			e.printStackTrace();
		}

	}

	public void excluir() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produtos);

			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Produto Excluido Com Sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemSucesso("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produtos);

			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Produto Editado Com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possivel Editar o Produto");
			e.printStackTrace();

		}

	}
	
	

}
