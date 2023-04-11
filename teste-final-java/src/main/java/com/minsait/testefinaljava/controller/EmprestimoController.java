package com.minsait.testefinaljava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.testefinaljava.dto.EmprestimoDTO;
import com.minsait.testefinaljava.dto.EmprestimoRespostaDTO;
import com.minsait.testefinaljava.entity.Emprestimo;
import com.minsait.testefinaljava.exception.ClienteNaoEncontradoException;
import com.minsait.testefinaljava.exception.DataFinalAntesDeInicial;
import com.minsait.testefinaljava.exception.IdNaoEncontradoException;
import com.minsait.testefinaljava.exception.IdNaoPertenceAEsseCpf;
import com.minsait.testefinaljava.exception.ValorTotalDeEmprestimosNaoPermitido;
import com.minsait.testefinaljava.service.EmprestimoService;
import com.minsait.testefinaljava.success.MensagemDeSucesso;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/teste-final/clientes/{cpf}/emprestimos")
public class EmprestimoController {

	private EmprestimoService emprestimoService;

	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmprestimoRespostaDTO cadastraEmprestimo(@PathVariable String cpf, @Valid @RequestBody EmprestimoDTO dto) throws ClienteNaoEncontradoException, ValorTotalDeEmprestimosNaoPermitido, DataFinalAntesDeInicial {	
		Emprestimo emprestimo = emprestimoService.cadastrarEmprestimo(cpf, dto.transformarParaEmprestimo());
		return EmprestimoRespostaDTO.transformaEmDTO(emprestimo);
	}
	
	
	@GetMapping
	public List<EmprestimoRespostaDTO> retornarTodosEmprestimos(@PathVariable String cpf) throws ClienteNaoEncontradoException{
		List<Emprestimo> emprestimo = this.emprestimoService.retornarTodosEmprestimo(cpf);
		return EmprestimoRespostaDTO.transformaListaEmDTO(emprestimo);
	}
	
	@GetMapping("/{id}")
	public EmprestimoRespostaDTO retornarEmprestimo(@PathVariable Long id) throws IdNaoEncontradoException {
		Emprestimo emprestimo = this.emprestimoService.retornarEmprestimo(id);
		return EmprestimoRespostaDTO.transformaEmDTO(emprestimo);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public MensagemDeSucesso deletarEmprestimo(@PathVariable Long id,@PathVariable String cpf ) throws IdNaoEncontradoException, IdNaoPertenceAEsseCpf, ClienteNaoEncontradoException {
		return this.emprestimoService.deletarEmprestimo(id,cpf);
	}
	
}
