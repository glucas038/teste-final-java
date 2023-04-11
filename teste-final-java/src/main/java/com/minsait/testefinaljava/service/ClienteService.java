package com.minsait.testefinaljava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.testefinaljava.entity.Cliente;
import com.minsait.testefinaljava.entity.Emprestimo;
import com.minsait.testefinaljava.exception.ClienteJaExiste;
import com.minsait.testefinaljava.exception.ClienteNaoEncontradoException;
import com.minsait.testefinaljava.exception.CpfErrado;
import com.minsait.testefinaljava.exception.NaoPodeMudarCpf;
import com.minsait.testefinaljava.repository.ClienteRepository;
import com.minsait.testefinaljava.repository.EmprestimoRepository;
import com.minsait.testefinaljava.repository.EnderecoRepository;
import com.minsait.testefinaljava.success.MensagemDeSucesso;

import jakarta.validation.Valid;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente cadastrarCliente (@Valid Cliente cliente) throws ClienteJaExiste, CpfErrado {
		if(clienteRepository.existsById(cliente.getCpf())) {
			throw new ClienteJaExiste(cliente.getCpf());
		}
		if(!(cliente.getCpf().length() == 11)) {
			throw new CpfErrado(cliente.getCpf());
		}
		if(!(cliente.getCpf().matches("^\\d+$"))) {
			throw new CpfErrado(cliente.getCpf());
		}
		return this.clienteRepository.save(cliente);
		
	}

	public List<Cliente> retornarTodosClientes() {
		return this.clienteRepository.findAll();
	}

	public Cliente retornarCliente(String cpf) throws ClienteNaoEncontradoException {
		if(this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.findById(cpf).get();
		}	
		throw new ClienteNaoEncontradoException(cpf);
	}

	public Cliente alterarCliente(String cpf, @Valid Cliente clienteModificado) throws ClienteNaoEncontradoException, NaoPodeMudarCpf {
		if(!this.clienteRepository.existsById(cpf)) {
			throw new ClienteNaoEncontradoException(cpf);
		}
		
		if(!clienteModificado.getCpf().equals(cpf)) {
			throw new NaoPodeMudarCpf();
		}
		
		Long enderecoAExcluir = clienteRepository.findById(cpf).get().getEndereco().getId();
		
		Cliente clienteAlteradoComSucesso = this.clienteRepository.save(clienteModificado);
		enderecoRepository.deleteById(enderecoAExcluir);
		return clienteAlteradoComSucesso;
		
	}

	public MensagemDeSucesso deletarCliente(String cpf) throws ClienteNaoEncontradoException {
		if(this.clienteRepository.existsById(cpf)) {
	
			List <Emprestimo> todosEmprestimos = emprestimoRepository.findAll();
			for(Emprestimo emprestimo : todosEmprestimos) {
				if(emprestimo.getCpfCliente().equals(cpf)) {
					emprestimoRepository.delete(emprestimo);
				}
			}	
			
			this.clienteRepository.deleteById(cpf);		
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Deletado com sucesso");
			return mensagem;
		}	
		throw new ClienteNaoEncontradoException(cpf);
	}
}








