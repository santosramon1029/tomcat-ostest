package br.com.javamon.model.DAO.connections;

import java.sql.Connection;

import br.com.javamon.model.exceptions.PersistenceException;

public class DAOConnectionFactory {
	
	private static DAOConnectionFactory instance = null;
	
	private DAOConnectionFactory() {
	}
	
	public static DAOConnectionFactory getInstance() {
		if(instance == null) {
			synchronized (DAOConnectionFactory.class) {
				if(instance == null) {
					instance = new DAOConnectionFactory();
				}
			}
		}
		
		return instance;
	}
	
	public Connection getConnection() throws PersistenceException  {
		DAOConnection daoConnection =	 JDBCMySQLConnection.getInstance();
		Connection conn = daoConnection.getConnection();
		
		return conn;
	}
}
