package br.com.javamon.model.DAO.connections;

import java.sql.Connection;

import br.com.javamon.model.exceptions.PersistenceException;

public interface DAOConnection {

	public Connection getConnection()throws PersistenceException ;
	
}
