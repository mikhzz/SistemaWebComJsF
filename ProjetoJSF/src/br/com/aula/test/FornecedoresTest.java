package br.com.aula.test;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.aula.DAO.FornecedoresDAO;
import br.com.aula.domain.Fornecedores;

public class FornecedoresTest {

	public static void main(String[] args) {

		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("TIJOLOS S.A");

		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("CIMENTO REAL LTDA.");

		FornecedoresDAO dao = new FornecedoresDAO();
		try {
			dao.salvar(f1);
			dao.salvar(f2);
			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}

	}
}
