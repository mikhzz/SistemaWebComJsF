package br.com.aula.test;

import java.sql.SQLException;

import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.domain.Fornecedores;

public class FornecedoresTestEditar {

	public static void main(String[] args) {
		
		Fornecedores f1 = new Fornecedores();
		f1.setIdFornecedores(4);
		f1.setDescricao("Testando Update");
		
		FornecedoresDAO dao = new FornecedoresDAO();
		try {
			dao.editar(f1);
			System.out.println("Editado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}
		
		
		
	}

}
