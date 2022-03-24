package com.mcf.diagnosis.model.exception;

public class PersonNotFoundException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PersonNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public PersonNotFoundException(Long id) {
		this(String.format("Não existe cadastro para a pessoa com o código %d", id));
	}
}
