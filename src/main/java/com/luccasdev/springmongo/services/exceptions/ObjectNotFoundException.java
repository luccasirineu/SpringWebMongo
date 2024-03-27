package com.luccasdev.springmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException { // serve para a exceção nao ser tratada agora
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
