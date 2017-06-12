package br.com.ncisaude.gr.infra.jsend;

public enum JSENDStatus {
	success,
	/** Deve ser utilizado em falhas de validacao */
	fail,
	/** Deve ser utilizado em erros internos */
	error
}
