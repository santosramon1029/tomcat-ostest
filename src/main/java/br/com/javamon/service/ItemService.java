package br.com.javamon.service;

import java.util.List;

import br.com.javamon.model.DAO.ItemDAO;
import br.com.javamon.model.domain.Item;
import br.com.javamon.model.exceptions.PersistenceException;

public class ItemService {

	private ItemDAO itemDAO = ItemDAO.getInstance();
	
	public Item getItemById(int id) {
		Item item = null;
		try {
			item = itemDAO.getElementByID(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public Item insertItem(Item item) {
		try {
			item = itemDAO.save(item);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<Item> getAllItens(){
		List<Item>itens =null;
		try {
			itens = itemDAO.getAllElements();
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		return itens;
	}
	
	public void deleteItem(int patrimonio) {
		try {
			itemDAO.delete(patrimonio);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
	
	public Item update(Item item) {
		try {
			item = itemDAO.update(item);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	

	
}
