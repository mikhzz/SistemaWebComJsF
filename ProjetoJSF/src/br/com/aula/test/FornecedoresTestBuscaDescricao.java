package br.com.aula.test;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.domain.Fornecedores;

public class FornecedoresTestBuscaDescricao {

	public static void main(String[] args) {
		
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("tijolo");

		FornecedoresDAO dao = new FornecedoresDAO();
		try {
			
			ArrayList<Fornecedores>lista = dao.buscarPorDescricao(f1);
			for(Fornecedores f : lista) {
				System.out.println("Resultado: " + f);

			}

		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}
		
		
		
	}

}
