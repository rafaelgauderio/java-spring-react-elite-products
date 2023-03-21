package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes;

public class ExcecaoIntegridadeBancoDeDados extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcecaoIntegridadeBancoDeDados (String mensagem) {
		super(mensagem);
	}

}
