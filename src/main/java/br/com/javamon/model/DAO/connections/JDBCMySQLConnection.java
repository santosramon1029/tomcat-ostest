package br.com.javamon.model.DAO.connections;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import br.com.javamon.model.exceptions.PersistenceException;
import br.com.javamon.resources.ContextServlet;

public class JDBCMySQLConnection implements DAOConnection {

	private Connection conn = null;
	private Properties config = null;
	private static JDBCMySQLConnection instance;
	
	private JDBCMySQLConnection() {
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
			config = new Properties();
			String applicationContextPath = ContextServlet.context.getRealPath("WEB-INF/mysql-db-config.properties");
			config.load(new FileInputStream( new File(applicationContextPath) ) );
			Class.forName(config.getProperty("br.com.stm.db.databaseClass"));
			this.conn = DriverManager.getConnection(config.getProperty("br.com.stm.db.connectionUrl"),
								config);
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e, "error trying to connect to the mysql database: " + e.getMessage());
		}

		return conn;
	}

	
	public static void main(String[] args) throws Exception{
		JDBCMySQLConnection.getInstance();
	}
	
	
}
