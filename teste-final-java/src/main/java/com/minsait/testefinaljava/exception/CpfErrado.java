package com.minsait.testefinaljava.exception;

public class CpfErrado extends Exception {

	private static final long serialVersionUID = 1L;

	public CpfErrado(String cpf) {
		super(String.format("O cpf %s não possui a quantidade necessaria de caracteres ou não possui somente números", cpf));
	}
}
