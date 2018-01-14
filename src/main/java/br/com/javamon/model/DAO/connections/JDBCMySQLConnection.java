package br.com.javamon.model.DAO.connections;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.javamon.model.exceptions.PersistenceException;
import br.com.javamon.resources.ContextServlet;

public class JDBCMySQLConnection implements DAOConnection {

	private Connection conn = null;
	private ResourceBundle config = null;
	private static JDBCMySQLConnection instance;
	
	private JDBCMySQLConnection() {
		//config = ResourceBundle.getBundle(ContextServlet.context.getRealPath("res/dbconfig"));
	}
	
	public static JDBCMySQLConnection getInstance() {
		if(instance == null) {
			synchronized(JDBCMySQLConnection.class) {
				if(instance == null) {
					instance = new JDBCMySQLConnection();		
				}
			}
		}
		return instance;
	}
	
	
	@Override
	public Connection getConnection() throws PersistenceException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10215657",
								"sql10215657",
								"n1QtUp7F11");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e, "error trying to connect to the mysql database: " + e.getMessage());
		}

		return conn;
	}

	
	public static void main(String[] args) throws Exception{
		JDBCMySQLConnection.getInstance();
	}
	
	
}
