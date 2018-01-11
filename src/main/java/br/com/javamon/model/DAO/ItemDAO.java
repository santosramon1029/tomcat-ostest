package br.com.javamon.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.javamon.model.DAO.connections.DAOConnectionFactory;
import br.com.javamon.model.domain.Item;
import br.com.javamon.model.exceptions.PersistenceException;

public class ItemDAO implements GenericDAO<Item>{

	private static ItemDAO instance = null;
	
	private ItemDAO () {
		
	}
	
	public static ItemDAO getInstance() {
		if(instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}
	
	@Override
	public Item getElementByID(int id) throws PersistenceException{
		
		Connection conn = null;
		Item item = null; 
		
		try{
			 conn = DAOConnectionFactory.getInstance().getConnection();
			
			String sql = "SELECT * FROM patrimonio_info WHERE patrimonio = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				item = new Item(result.getInt("patrimonio"),
						result.getString("local"),
						result.getString("usuario"),
						result.getString("descricao"),
						result.getString("secao"));
			}
			
		}catch(SQLException e) {
			throw new PersistenceException(e, "sql operation error, select query: " + e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return item;
	}

	@Override
	public Item save(Item item ) throws PersistenceException{
		Connection conn = null;
		try {
		    conn = DAOConnectionFactory.getInstance().getConnection();
			String sql = "INSERT INTO patrimonio_info (patrimonio, local, usuario, descricao, secao)"
								+ "VALUES (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, item.getPatrimonio());
			statement.setString(2, item.getLocal());
			statement.setString(3, item.getUsuario());
			statement.setString(4, item.getDescricao());
			statement.setString(5, item.getSecao());
			statement.execute();
			
		} catch (Exception e) {
			throw new PersistenceException(e, "an insertion error persistence ocourred: " + e.getMessage());
		}finally {
			try {
				if(conn != null) {
					conn.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return item;
	}

	@Override
	public List<Item> getAllElements() throws PersistenceException{
		List<Item> itens = null;
		Connection conn = null;
		try {
			conn = DAOConnectionFactory.getInstance().getConnection();
			String sql = "SELECT * FROM patrimonio_info";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet set = statement.executeQuery();
			itens = new ArrayList<Item>();
			while(set.next()) {
				itens.add(new Item(set.getInt("patrimonio"),
						set.getString("local"),
						set.getString("usuario"),
						set.getString("descricao"),
						set.getString("secao")));
			}
		}catch(Exception e) {
			throw new PersistenceException(e, " ");
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new PersistenceException(e, " ");
			}
		}
			
		return itens;
	}
	
	
	public void delete(int primaryKey)throws PersistenceException{
		Connection conn = null;
		
		try {
			conn = DAOConnectionFactory.getInstance().getConnection();
			String sql = "DELETE FROM patrimonio_info WHERE patrimonio = ?";
			PreparedStatement statement  = conn.prepareStatement(sql);
			statement.setInt(1, primaryKey);
			statement.execute();
		} catch (SQLException e) {
			throw new PersistenceException(e, " ");
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new PersistenceException(e, " ");
			}
		}
	}
	
	public Item update(Item item) throws PersistenceException{
		Connection conn = null;
		Item itemManaged = null;
		
		try {
			conn = DAOConnectionFactory.getInstance().getConnection();
			String sql = "UPDATE patrimonio_info SET local = ?,"
					+ "usuario = ?,"
					+ "descricao = ?,"
					+ "secao = ?"
					+ "WHERE patrimonio = ?";
			PreparedStatement statement  = conn.prepareStatement(sql);
			statement.setString(1, item.getLocal());
			statement.setString(2, item.getUsuario());
			statement.setString(3, item.getDescricao());
			statement.setString(4, item.getSecao());
			statement.setInt(5, item.getPatrimonio());
			statement.execute();
			
			itemManaged = item;
			
		} catch (SQLException e) {
			throw new PersistenceException(e, " ");
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			
			} catch (SQLException e) {
				throw new PersistenceException(e, " ");
			}
		}
		
		return itemManaged;
	}
	
	
	

	
}



















