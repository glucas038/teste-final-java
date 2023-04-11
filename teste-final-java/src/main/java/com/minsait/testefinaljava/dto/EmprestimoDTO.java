package com.minsait.testefinaljava.dto;

import java.math.BigDecimal;

import com.minsait.testefinaljava.entity.Emprestimo;
import com.minsait.testefinaljava.enums.Relacionamento;

import jakarta.validation.constraints.NotNull;

public class EmprestimoDTO {

	@NotNull(message= "Valor Inicial do emprestimo não pode ser nulo")
	private BigDecimal valorInicial;
	@NotNull(message= "Dia final não pode ser nulo")
	private Integer diaFinal;
	@NotNull(message= "Mes final não pode ser nulo")
	private Integer mesFinal;
	@NotNull(message= "Ano final não pode ser nulo")
	private Integer anoFinal;
	private Relacionamento relacionamento;
	
	public Emprestimo transformarParaEmprestimo() {
		return new Emprestimo(this.valorInicial,this.relacionamento,this.diaFinal,this.mesFinal,this.anoFinal);
	}
	
	public BigDecimal getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}
	public Integer getDiaFinal() {
		return diaFinal;
	}
	public void setDiaFinal(Integer diaFinal) {
		this.diaFinal = diaFinal;
	}
	public Integer getMesFinal() {
		return mesFinal;
	}
	public void setMesFinal(Integer mesFinal) {
		this.mesFinal = mesFinal;
	}
	public Integer getAnoFinal() {
		return anoFinal;
	}
	public void setAnoFinal(Integer anoFinal) {
		this.anoFinal = anoFinal;
	}
	public Relacionamento getRelacionamento() {
		return relacionamento;
	}
	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}
	
}
