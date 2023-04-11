package com.minsait.testefinaljava.enums;

import java.math.BigDecimal;
import java.math.MathContext;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Valid
public enum Relacionamento {

	BRONZE(0){
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorInicial, int quantidadeEmprestimo) {
			BigDecimal fatorMultiplicador = new BigDecimal(1.8);
			return valorInicial.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
		
	},
	PRATA(1){
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorInicial, int quantidadeEmprestimo) {
			if(valorInicial.longValue() > 5000) {
				BigDecimal fatorMultiplicador = new BigDecimal(1.4);
				return valorInicial.multiply(fatorMultiplicador, MathContext.DECIMAL32);
			} 
			BigDecimal fatorMultiplicador = new BigDecimal(1.6);
			return valorInicial.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
		
	},
	OURO(2){
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorInicial, int quantidadeEmprestimo) {
			if(quantidadeEmprestimo <= 1) {
				BigDecimal fatorMultiplicador = new BigDecimal(1.2);
				return valorInicial.multiply(fatorMultiplicador, MathContext.DECIMAL32);
			} 
			BigDecimal fatorMultiplicador = new BigDecimal(1.3);
			return valorInicial.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
		
	};
	
	@Min(value = 0, message= "Relacionamento não pode ser menor que 0")
	@Max(value = 2, message= "Relacionamento não pode ser maior que 2")
	private int codigo;
	
	private Relacionamento(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public abstract BigDecimal calculaValorFinal(BigDecimal ValorInicial, int quantidadeEmprestimo);
}
