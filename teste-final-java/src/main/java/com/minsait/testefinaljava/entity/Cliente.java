package com.minsait.testefinaljava.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Valid
public class Cliente {
	
	@Id
	@NotEmpty(message= "CPF não pode ser nulo")
	private String cpf;
	
	@NotEmpty(message= "Nome não pode ser nulo")
	private String nome;
	
	@NotEmpty(message= "Telefone não pode ser nulo")
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private Endereco endereco;
	
	@NotNull(message= "Rendimento mensal não pode ser nulo")
	@Min(value = 0)
	private BigDecimal rendimentoMensal;
	
	public Cliente() {
	}
	
	public Cliente(String cpf, @NotEmpty(message = "Nome não pode ser nulo") String nome,
			@NotEmpty(message = "Telefone não pode ser nulo") String telefone,
			@NotEmpty(message = "Endereço não pode ser nulo") Endereco endereco,
			@NotNull(message = "Rendimento mensal não pode ser nulo") @Min(0) BigDecimal rendimentoMensal) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rendimentoMensal = rendimentoMensal;
	}
	
	public Cliente(@NotEmpty(message = "CPF não pode ser nulo") String cpf,
			@NotEmpty(message = "Nome não pode ser nulo") String nome,
			@NotEmpty(message = "Telefone não pode ser nulo") String telefone, @Valid Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}
	
	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
}
