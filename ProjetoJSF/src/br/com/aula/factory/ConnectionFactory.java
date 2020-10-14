package br.com.aula.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	private static final String USUARIO = "root";
	private static final String SENHA = "ohio1907";
	private static final String URL = "jdbc:mysql://localhost:3306/produto";
	
	public static Connection conectar() throws SQLException {
		
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.conectar();
			System.out.println("Conectado ao db do Mikael!");
		} catch (SQLException e) {
			System.out.println("Erro:"+e);
			
		}
	}
	
	
	
	
	

}
