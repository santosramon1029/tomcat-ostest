package br.com.javamon.model.DAO.connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.javamon.model.exceptions.PersistenceException;

public class JDBCMySQLConnection implements DAOConnection {

	private Connection conn = null;
	private ResourceBundle config = null;
	private static JDBCMySQLConnection instance;
	
	private JDBCMySQLConnection() {
		config = ResourceBundle.getBundle("res/dbconfig");
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
			Class.forName(config.getString("br.com.stm.db.databaseClass"));
			this.conn = DriverManager.getConnection(config.getString("br.com.stm.db.connectionUrl"),
								config.getString("br.com.stm.db.user"),
								config.getString("br.com.stm.db.password"));
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e, "error trying to connect to the mysql database: " + e.getMessage());
		}

		return conn;
	}

	
	
	
	
}
