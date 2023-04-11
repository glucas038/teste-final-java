package com.minsait.testefinaljava.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.minsait.testefinaljava.entity.Cliente;

public class ClienteRespostaDTO {
	
	private String cpf;
	private String nome;
	private String telefone;	
	private EnderecoRespostaDTO endereco;
	private BigDecimal rendimentoMensal;
	
	private ClienteRespostaDTO(String cpf,String nome, String telefone, EnderecoRespostaDTO enderecoRespostaDTO, BigDecimal rendimentoMensal) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = enderecoRespostaDTO;
		this.rendimentoMensal = rendimentoMensal;
	}

	public static ClienteRespostaDTO transformaEmDTO(Cliente cliente) {
		return new ClienteRespostaDTO(cliente.getCpf(),cliente.getNome(),cliente.getTelefone(),EnderecoRespostaDTO.transformaEmDTO(cliente.getEndereco()),cliente.getRendimentoMensal());
	}
	
	public static List<ClienteRespostaDTO> transformaListaEmDTO(List<Cliente> clienteLista) {
		List<ClienteRespostaDTO> listaDTO = new ArrayList<>();
		for(Cliente cliente: clienteLista) {
			listaDTO.add(new ClienteRespostaDTO(cliente.getCpf(),cliente.getNome(),cliente.getTelefone(),EnderecoRespostaDTO.transformaEmDTO(cliente.getEndereco()),cliente.getRendimentoMensal()));
		}
		return listaDTO;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public EnderecoRespostaDTO getEndereco() {
		return endereco;
	}

	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}


}
