package br.com.mobi.exceptions;

public class RuleException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RuleException(){
		super("Object not found");
	}

	public RuleException(String msg) {
		super(msg);
	}
	
}
