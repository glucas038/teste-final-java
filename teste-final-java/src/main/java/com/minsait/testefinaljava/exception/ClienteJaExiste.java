package com.minsait.testefinaljava.exception;

public class ClienteJaExiste extends Exception{

	private static final long serialVersionUID = 1L;

	public ClienteJaExiste(String cpf) {
		super(String.format("O cpf %s já está cadastrado no banco de dados", cpf));
	}
}
