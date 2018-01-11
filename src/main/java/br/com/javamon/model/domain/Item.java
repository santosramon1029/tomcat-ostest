package br.com.javamon.model.domain;

public class Item {

	private int patrimonio;
	private String local;
	private String usuario;
	private String descricao;
	private String secao;
	
	public Item() {
		
	}
	
	public Item(int patrimonio, String local, String usuario, String descricao, String secao) {
		super();
		this.patrimonio = patrimonio;
		this.local = local;
		this.usuario = usuario;
		this.descricao = descricao;
		this.secao = secao;
	}
	
	public int getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(int patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	
	@Override
	public String toString() {
		String s = patrimonio + ", " + local + ", " + usuario + ", " + descricao + ", " + secao;
		return s;
	}
	
}
