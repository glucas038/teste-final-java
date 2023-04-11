package com.minsait.testefinaljava.exception;

public class IdNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public IdNaoEncontradoException(Long id) {
		super(String.format("O id %d não foi encontrado", id));
	}

}