package com.minsait.testefinaljava.exception;

import java.math.BigDecimal;

public class ValorTotalDeEmprestimosNaoPermitido extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ValorTotalDeEmprestimosNaoPermitido(BigDecimal valorTotal) {
		super(String.format("O valor total de %f não é permitido para esse cliente", valorTotal.floatValue()));
	}

}
