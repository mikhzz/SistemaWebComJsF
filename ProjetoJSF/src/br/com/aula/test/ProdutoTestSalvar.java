package br.com.aula.test;

import java.sql.SQLException;


import br.com.aula.DAO.ProdutoDAO;
import br.com.aula.domain.Fornecedores;
import br.com.aula.domain.Produtos;

public class ProdutoTestSalvar {

	public static void main(String[] args) {
		
		Fornecedores f2 = new Fornecedores();
		Produtos f1 = new Produtos();
	    
	    f2.setIdFornecedores(5);
		f1.setDescricao("CIMENTOS NASSAU");
		f1.setQuantidade(500);
		f1.setPreco(48.50);
		f1.setFornecedor(f2);
		
		
		

		ProdutoDAO dao = new ProdutoDAO();
		try {
			dao.salvar(f1);
			
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}

	}
		
		
		

	}


