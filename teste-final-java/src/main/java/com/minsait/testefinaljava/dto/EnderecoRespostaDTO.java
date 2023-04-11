package com.minsait.testefinaljava.dto;

import java.math.BigDecimal;

import com.minsait.testefinaljava.entity.Endereco;

public class EnderecoRespostaDTO {

	private String rua;
	private BigDecimal numero;
	private String cep;
	
	public EnderecoRespostaDTO(String rua, BigDecimal numero, String cep) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public static EnderecoRespostaDTO transformaEmDTO(Endereco endereco) {
		return new EnderecoRespostaDTO(endereco.getRua(),endereco.getNumero(),endereco.getCep());
	}

	public String getRua() {
		return rua;
	}

	public BigDecimal getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

}
