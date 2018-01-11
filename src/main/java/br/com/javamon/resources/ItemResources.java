package br.com.javamon.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.javamon.model.domain.Item;
import br.com.javamon.service.ItemService;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ItemResources {

	ItemService itemService = new ItemService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Item>getItems(){
		return itemService.getAllItens();
	}
	
	@GET
	@Path("{patrimonio}")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Item getItem(@PathParam("patrimonio") int id) {
		return itemService.getItemById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public void save(Item item) {
		itemService.insertItem(item);
	}
	
	@DELETE
	@Path("{patrimonio}")
	public void delete(@PathParam("patrimonio") int patrimonio) {
		itemService.deleteItem(patrimonio);
	}
	
	@PUT
	@Path("{patrimonio}")
	public void update(@PathParam("patrimonio") int patrimonio, Item newItem) {
		newItem.setPatrimonio(patrimonio);
		itemService.update(newItem);
	}
}









