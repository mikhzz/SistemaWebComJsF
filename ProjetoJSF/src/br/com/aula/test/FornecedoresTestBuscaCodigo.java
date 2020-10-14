package br.com.aula.test;

import java.sql.SQLException;

import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.domain.Fornecedores;

public class FornecedoresTestBuscaCodigo {

	public static void main(String[] args) {
		
		Fornecedores f1 = new Fornecedores();
		f1.setIdFornecedores(3);
		
		FornecedoresDAO dao = new FornecedoresDAO();
		try {
			
			Fornecedores resultado = dao.buscaporcodigo(f1);
			System.out.println("Resultado: " + resultado);
			
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}
		
		
		
		
	}

}
