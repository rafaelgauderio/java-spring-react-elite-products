package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes;

public class ExcecaoEntidadeNaoEncontrada extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ExcecaoEntidadeNaoEncontrada (String mensagem) {
		super(mensagem);
	}
}
