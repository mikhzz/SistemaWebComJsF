package br.com.aula.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.aula.domain.Fornecedores;
import br.com.aula.factory.ConnectionFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, f.getDescricao());

		stmt.executeUpdate();

	}

	public void excluir(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, f.getIdFornecedores());

		stmt.executeUpdate();

	}

	public void editar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setString(1, f.getDescricao());

		stmt.setInt(2, f.getIdFornecedores());

		stmt.executeUpdate();

	}

	public Fornecedores buscaporcodigo(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, f.getIdFornecedores());

		ResultSet resultado = stmt.executeQuery();
		Fornecedores retorno = null;

		if (resultado.next()) {

			retorno = new Fornecedores();
			retorno.setIdFornecedores(resultado.getInt("idfornecedores"));
			retorno.setDescricao(resultado.getString("descricao"));

		}

		return retorno;

	}

	public ArrayList<Fornecedores> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			
			f.setIdFornecedores(resultado.getInt("idfornecedores"));
			f.setDescricao(resultado.getString("descricao"));
			

			lista.add(f);
		}
		return lista;

	}

	public ArrayList<Fornecedores> buscarPorDescricao(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores item = new Fornecedores();
			item.setIdFornecedores(resultado.getInt("idfornecedores"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);
		}
		return lista;

	}

	public ArrayList<Fornecedores> listaCombo() throws SQLException  {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao");
		sql.append("FROM fornecedores ");
		

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			
			f.setDescricao(resultado.getString("descricao"));
			f.setIdFornecedores(resultado.getInt("idfornecedores"));

			lista.add(f);
		}
		return lista;
		
		
		
		
		
	}

	public Fornecedores buscaporcodigo(int idFornecedores) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE idfornecedores = ? ");

		Connection conexao = ConnectionFactory.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		Fornecedores retorno = null;
		
		try {
			stmt.setInt(1, idFornecedores);
	
			ResultSet resultado = stmt.executeQuery();
			
			
	
			if (resultado.next()) {
	
				retorno = new Fornecedores();
				retorno.setIdFornecedores(resultado.getInt("idfornecedores"));
				retorno.setDescricao(resultado.getString("descricao"));
				
			}
		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar fornecedor. Codigo: " + idFornecedores + " .Causa: " + ex.getMessage());
		}

		return retorno;
	
}
}
