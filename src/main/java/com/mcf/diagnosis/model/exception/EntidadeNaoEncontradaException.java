package com.mcf.diagnosis.model.exception;

public class EntidadeNaoEncontradaException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
