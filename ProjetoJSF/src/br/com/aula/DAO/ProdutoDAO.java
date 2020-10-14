package br.com.aula.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.aula.domain.Fornecedores;
import br.com.aula.domain.Produtos;
import br.com.aula.factory.ConnectionFactory;

public class ProdutoDAO {

	public void salvar(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, quantidade, preco, idfornecedores) ");
		sql.append("VALUES (?,?,?,?) ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, produtos.getDescricao());
		stmt.setDouble(2, produtos.getPreco());
		stmt.setInt(3, produtos.getQuantidade());
		stmt.setInt(4, produtos.getFornecedor().getIdFornecedores());

		stmt.executeUpdate();

	}

	public ArrayList<Produtos> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idprodutos, descricao, quantidade, preco, idfornecedores ");
		sql.append("FROM produtos ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
			Produtos retorno = new Produtos();
			retorno.setIdProdutos(resultado.getInt("idprodutos"));
			retorno.setDescricao(resultado.getString("descricao"));
			retorno.setQuantidade(resultado.getInt("quantidade"));
			retorno.setPreco(resultado.getDouble("preco"));

			FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
			Fornecedores fornecedores = fornecedoresDAO.buscaporcodigo(resultado.getInt("idfornecedores"));
			retorno.setFornecedor(fornecedores);

			lista.add(retorno);
		}
		return lista;

	}

	public void excluir(Produtos p1) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE idprodutos = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, p1.getIdProdutos());

		stmt.executeUpdate();

	}

	public void editar(Produtos p1) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?,  quantidade = ? , preco = ? ");
		sql.append("WHERE idprodutos = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setString(1, p1.getDescricao());
		stmt.setInt(3, p1.getQuantidade());
		stmt.setDouble(2, p1.getPreco());
		stmt.setInt(4, p1.getIdProdutos());

		stmt.executeUpdate();
	}

}
