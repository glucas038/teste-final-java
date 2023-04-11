package com.minsait.testefinaljava.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message= "Rua não pode ser nulo")
	private String rua;
	@NotNull(message= "Numero não pode ser nulo")
	private BigDecimal numero;
	@NotNull(message= "CEP não pode ser nulo")
	private String cep;
	
	public Endereco() {
	}
	
	public Endereco(String rua, BigDecimal numero, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public BigDecimal getNumero() {
		return numero;
	}
	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

