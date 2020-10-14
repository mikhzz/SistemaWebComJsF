package br.com.aula.test;

import java.sql.SQLException;

import br.com.aula.DAO.ProdutoDAO;
import br.com.aula.domain.Produtos;

public class ProdutoTestExcluir {

	public static void main(String[] args) {
		Produtos p1 = new Produtos();
		p1.setIdProdutos(1);
		
		ProdutoDAO dao = new ProdutoDAO();
		
		
		try {
			dao.excluir(p1);
			System.out.println("Deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}

	}
		
		
	}


