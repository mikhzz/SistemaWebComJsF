package br.com.aula.test;

import java.sql.SQLException;
import java.util.ArrayList;


import br.com.aula.DAO.ProdutoDAO;

import br.com.aula.domain.Produtos;

public class ProdutosTestLista {
	
	
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		try {
			
			ArrayList<Produtos>lista = dao.listar();
			
			for(Produtos f : lista) {
				System.out.println("Resultado: " + f);

			}

		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}
	}
	
	
	

}
