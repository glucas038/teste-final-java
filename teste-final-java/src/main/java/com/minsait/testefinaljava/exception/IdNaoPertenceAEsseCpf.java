package com.minsait.testefinaljava.exception;

public class IdNaoPertenceAEsseCpf extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IdNaoPertenceAEsseCpf(Long id, String cpf) {
		super(String.format("O id %d do emprestimo não é do cpf %s", id,cpf));
	}
}
