package com.minsait.testefinaljava.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.testefinaljava.dto.ClienteDTO;
import com.minsait.testefinaljava.dto.ClienteRespostaDTO;
import com.minsait.testefinaljava.entity.Cliente;
import com.minsait.testefinaljava.exception.ClienteJaExiste;
import com.minsait.testefinaljava.exception.ClienteNaoEncontradoException;
import com.minsait.testefinaljava.exception.CpfErrado;
import com.minsait.testefinaljava.exception.NaoPodeMudarCpf;
import com.minsait.testefinaljava.service.ClienteService;
import com.minsait.testefinaljava.success.MensagemDeSucesso;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/teste-final/clientes")
public class ClienteController {

	private ClienteService clienteService; 
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteRespostaDTO cadastraCliente(@Valid @RequestBody ClienteDTO dto) throws ClienteJaExiste, CpfErrado {	
		Cliente cliente = clienteService.cadastrarCliente(dto.transformaParaCliente());
		return ClienteRespostaDTO.transformaEmDTO(cliente);
	}
	
	@GetMapping
	public List<ClienteRespostaDTO> retornarTodosClientes(){
		List<Cliente> clientes = this.clienteService.retornarTodosClientes();
		return ClienteRespostaDTO.transformaListaEmDTO(clientes);
	}
	
	@GetMapping("/{cpf}")
	public ClienteRespostaDTO retornarCliente(@PathVariable String cpf) throws ClienteNaoEncontradoException {
		Cliente cliente = this.clienteService.retornarCliente(cpf);
		return ClienteRespostaDTO.transformaEmDTO(cliente);
	}
	
	@PutMapping("/{cpf}")
	public ClienteRespostaDTO alterarCliente(@PathVariable String cpf, @Valid @RequestBody ClienteDTO dto) throws ClienteNaoEncontradoException, NaoPodeMudarCpf {
		Cliente cliente =  this.clienteService.alterarCliente(cpf, dto.transformaParaCliente());
		return ClienteRespostaDTO.transformaEmDTO(cliente);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{cpf}")
	public MensagemDeSucesso deletarCliente(@PathVariable String cpf) throws ClienteNaoEncontradoException {
		return this.clienteService.deletarCliente(cpf);
	}
	
}
