package br.com.javamon.model.DAO;

import java.util.List;

import br.com.javamon.model.domain.Item;
import br.com.javamon.model.exceptions.PersistenceException;

public interface GenericDAO<T> {

	T getElementByID (int primaryKey) throws PersistenceException;
	
	Item save(T element)throws PersistenceException;
	
	List<T> getAllElements() throws PersistenceException;
	
	void delete(int primaryKey)throws PersistenceException;
	
	Item update(Item item) throws PersistenceException;
}
