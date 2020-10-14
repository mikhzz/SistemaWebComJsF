package br.com.aula.test;

import java.sql.SQLException;

import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.domain.Fornecedores;

public class FornecedoresTestExcluir {

	public static void main(String[] args) {
		Fornecedores f1 = new Fornecedores();
		f1.setIdFornecedores(2);
		
		FornecedoresDAO dao = new FornecedoresDAO();
		try {
			dao.excluir(f1);
			System.out.println("Deletado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}

	}

}
