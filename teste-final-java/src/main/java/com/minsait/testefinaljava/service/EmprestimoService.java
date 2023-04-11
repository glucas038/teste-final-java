package com.minsait.testefinaljava.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.testefinaljava.entity.Cliente;
import com.minsait.testefinaljava.entity.Emprestimo;
import com.minsait.testefinaljava.exception.ClienteNaoEncontradoException;
import com.minsait.testefinaljava.exception.DataFinalAntesDeInicial;
import com.minsait.testefinaljava.exception.IdNaoEncontradoException;
import com.minsait.testefinaljava.exception.IdNaoPertenceAEsseCpf;
import com.minsait.testefinaljava.exception.ValorTotalDeEmprestimosNaoPermitido;
import com.minsait.testefinaljava.repository.EmprestimoRepository;
import com.minsait.testefinaljava.success.MensagemDeSucesso;

import jakarta.validation.Valid;

@Service
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;
	private BigDecimal valorTotal;
	private Integer quantidadeEmprestimos;
	
    @Autowired
	private ClienteService clienteService;
    
	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository) {
		this.emprestimoRepository = emprestimoRepository;
	}
	
	public Emprestimo cadastrarEmprestimo(String cpf, @Valid Emprestimo emprestimo) throws ClienteNaoEncontradoException, ValorTotalDeEmprestimosNaoPermitido, DataFinalAntesDeInicial {
		Cliente cliente = clienteService.retornarCliente(cpf);
		emprestimo.setCpfCliente(cpf);
		
		valorTotal = new BigDecimal(0);
		quantidadeEmprestimos = 0;
		List<Emprestimo> todosEmprestimos = this.retornarTodosEmprestimo(cpf);
		
		for(Emprestimo emprestimosCliente: todosEmprestimos) {
			valorTotal = valorTotal.add(emprestimosCliente.getValorInicial());
			quantidadeEmprestimos+=1;
		}
		
		BigDecimal limiteEmprestimo = cliente.getRendimentoMensal().multiply(new BigDecimal(10));
			
		emprestimo.setDataAtual(Calendar.getInstance());
		emprestimo.setDataFinal(Calendar.getInstance());
		emprestimo.getDataFinal().set(emprestimo.getAno(), emprestimo.getMes()-1, emprestimo.getDia());
		
		if(!emprestimo.getDataFinal().after(emprestimo.getDataAtual())) {
			throw new DataFinalAntesDeInicial();
		}
		
		valorTotal = valorTotal.add(emprestimo.getValorInicial());
		if(valorTotal.compareTo(limiteEmprestimo) == 1) {
			throw new ValorTotalDeEmprestimosNaoPermitido(valorTotal);
		}
		
		emprestimo.setValorFinal(emprestimo.getRelacionamento().calculaValorFinal(emprestimo.getValorInicial(), quantidadeEmprestimos));

		return emprestimoRepository.save(emprestimo);
	}
	
	public List<Emprestimo> retornarTodosEmprestimo(String cpf) throws ClienteNaoEncontradoException {
		
		clienteService.retornarCliente(cpf);
		
		List <Emprestimo> todosEmprestimos = emprestimoRepository.findAll();
		List <Emprestimo> todosEmprestimosClienteAtual = new ArrayList<>();

		for(Emprestimo emprestimo : todosEmprestimos) {
			if(emprestimo.getCpfCliente().equals(cpf)) {
				todosEmprestimosClienteAtual.add(emprestimo);
			}
		}
		
		return todosEmprestimosClienteAtual;
	}

	public Emprestimo retornarEmprestimo(Long id) throws IdNaoEncontradoException {		
		if(emprestimoRepository.existsById(id)) {
			return emprestimoRepository.findById(id).get();
		}
		throw new IdNaoEncontradoException(id);
	}

	public MensagemDeSucesso deletarEmprestimo(Long id, String cpf) throws IdNaoEncontradoException, IdNaoPertenceAEsseCpf, ClienteNaoEncontradoException {
		if(this.emprestimoRepository.existsById(id)) {
			Emprestimo emprestimo = emprestimoRepository.findById(id).get();
			
			if((emprestimo.getId() == id) && (emprestimo.getCpfCliente().equals(cpf))) {	
				this.emprestimoRepository.deleteById(id);			
				MensagemDeSucesso mensagem = new MensagemDeSucesso();
				mensagem.setMensagem("Deletado com sucesso");
				
				return mensagem;
			}
			
			throw new IdNaoPertenceAEsseCpf(id,cpf);
		}
		throw new IdNaoEncontradoException(id);
	}
}







