package com.minsait.testefinaljava.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.minsait.testefinaljava.entity.Emprestimo;
import com.minsait.testefinaljava.enums.Relacionamento;

public class EmprestimoRespostaDTO {
	
	private Long id;
	private String cpfCliente;
	private BigDecimal valorFinal;
	private Calendar dataAtual;
	private Calendar dataFinal;
	private BigDecimal valorInicial;
	private Relacionamento relacionamento;
	
	public EmprestimoRespostaDTO(Long id, String cpfCliente, BigDecimal valorInicial, BigDecimal valorFinal,
			Calendar dataAtual, Calendar dataFinal, Relacionamento relacionamento) {
		super();
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.valorFinal = valorFinal;
		this.dataAtual = dataAtual;
		this.dataFinal = dataFinal;
		this.valorInicial = valorInicial;
		this.relacionamento = relacionamento;
	}

	public static EmprestimoRespostaDTO transformaEmDTO(Emprestimo emprestimo) {
		return new EmprestimoRespostaDTO(emprestimo.getId(),emprestimo.getCpfCliente(),emprestimo.getValorInicial(),emprestimo.getValorFinal(),
				emprestimo.getDataAtual(),emprestimo.getDataFinal(),emprestimo.getRelacionamento());
	}
	
	public static List<EmprestimoRespostaDTO> transformaListaEmDTO(List<Emprestimo> emprestimoLista) {
		List<EmprestimoRespostaDTO> listaDTO = new ArrayList<>();
		for(Emprestimo emprestimo: emprestimoLista) {
			listaDTO.add(new EmprestimoRespostaDTO(emprestimo.getId(),emprestimo.getCpfCliente(),emprestimo.getValorInicial(),emprestimo.getValorFinal(),
					emprestimo.getDataAtual(),emprestimo.getDataFinal(),emprestimo.getRelacionamento()));
		}
		return listaDTO;
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

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Calendar getDataAtual() {
		return dataAtual;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public Relacionamento getRelacionamento() {
		return relacionamento;
	}

}
