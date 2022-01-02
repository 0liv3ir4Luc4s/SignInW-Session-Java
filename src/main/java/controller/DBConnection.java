package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection;
	
	public DBConnection() {
	    try {
		String user = "admin";
		String password = "1";
		String dbname = "login";
		String host = "localhost";
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.setConnection(DriverManager.getConnection("jdbc:mysql://"+host+"/"+dbname, user, password));
	    } catch (SQLException SQLex) {
		System.out.println("Erro ao conectar com o BD: "+SQLex.getMessage());
	    } catch (Exception ex) {
		System.out.println("Erro geral: "+ex.getMessage());
	    }
	}
	
	public void setConnection(Connection connection) {
	    this.connection = connection;
	}
	
	public Connection getConnection() {
	    return this.connection;
	}
	
	public void closeConnection() {
	    try {
		this.connection.close();
	    } catch(SQLException SQLex) {
		System.out.println("Erro ao encerrar conexão com o BD: "+SQLex.getMessage());
	    }
	}
}
	
	