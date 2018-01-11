package br.com.javamon.model.exceptions;

public class PersistenceException extends Exception {

	private static final long serialVersionUID = -8847752115390488027L;
	
	public PersistenceException(Exception exception, String msg) {
		super(msg, exception);
	}
	
}
