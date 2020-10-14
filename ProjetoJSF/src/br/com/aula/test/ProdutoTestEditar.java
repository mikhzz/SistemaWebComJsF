package br.com.aula.test;

import java.sql.SQLException;

import br.com.aula.DAO.ProdutoDAO;
import br.com.aula.domain.Produtos;

public class ProdutoTestEditar {

	public static void main(String[] args) {
		Produtos p1 = new Produtos();
		p1.setIdProdutos(4);
		p1.setDescricao("teste update");
		p1.setQuantidade(100);
		p1.setPreco(100.00);

		ProdutoDAO dao = new ProdutoDAO();

		try {
			dao.editar(p1);
			System.out.println("Editado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro" + e);
			e.printStackTrace();
		}

	}

}


