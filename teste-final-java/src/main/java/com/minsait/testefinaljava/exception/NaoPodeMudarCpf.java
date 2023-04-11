package com.minsait.testefinaljava.exception;

public class NaoPodeMudarCpf extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NaoPodeMudarCpf() {
		super(String.format("Não pode alterar o cpf de uma pessoa já cadastrada"));
	}
}
