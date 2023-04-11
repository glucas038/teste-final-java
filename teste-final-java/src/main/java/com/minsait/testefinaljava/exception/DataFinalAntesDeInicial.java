package com.minsait.testefinaljava.exception;

public class DataFinalAntesDeInicial extends Exception {

	private static final long serialVersionUID = 1L;

	public DataFinalAntesDeInicial() {
		super(String.format("A data final não pode ser antes da data inicial"));
	}
	
}
