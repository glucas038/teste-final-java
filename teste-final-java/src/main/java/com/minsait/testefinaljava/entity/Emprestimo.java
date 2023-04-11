package com.minsait.testefinaljava.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import com.minsait.testefinaljava.enums.Relacionamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String cpfCliente;
	private BigDecimal valorFinal;
	private Calendar dataAtual;
	private Calendar dataFinal;
	
	//Itens obrigatórios a serem passados
	@NotNull(message= "Valor Inicial do emprestimo não pode ser nulo")
	private BigDecimal valorInicial;
	@NotNull(message= "Dia final não pode ser nulo")
	private Integer diaFinal;
	@NotNull(message= "Mes final não pode ser nulo")
	private Integer mesFinal;
	@NotNull(message= "Ano final não pode ser nulo")
	private Integer anoFinal;
	private Relacionamento relacionamento;
	

	public Emprestimo(Long id, String cpfCliente, BigDecimal valorInicial,
			Relacionamento relacionamento, BigDecimal valorFinal, Integer dia, Integer mes, Integer ano) {
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		this.dataAtual = Calendar.getInstance();
		this.dataFinal = Calendar.getInstance();
	}
	
	public Emprestimo() {
	}

	public Emprestimo(@NotNull(message = "Valor Inicial do emprestimo não pode ser nulo") BigDecimal valorInicial,
			Relacionamento relacionamento, @NotNull(message = "Dia final não pode ser nulo") Integer diaFinal,
			@NotNull(message = "Mes final não pode ser nulo") Integer mesFinal,
			@NotNull(message = "Ano final não pode ser nulo") Integer anoFinal) {
		this.valorInicial = valorInicial;
		this.relacionamento = relacionamento;
		this.diaFinal = diaFinal;
		this.mesFinal = mesFinal;
		this.anoFinal = anoFinal;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Relacionamento getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}

	public Calendar getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Calendar dataAtual) {
		this.dataAtual = dataAtual;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Integer getDia() {
		return diaFinal;
	}

	public void setDia(int dia) {
		this.diaFinal = dia;
	}

	public Integer getMes() {
		return mesFinal;
	}

	public void setMes(int mes) {
		this.mesFinal = mes;
	}

	public Integer getAno() {
		return anoFinal;
	}

	public void setAno(int ano) {
		this.anoFinal = ano;
	}	
	
}
