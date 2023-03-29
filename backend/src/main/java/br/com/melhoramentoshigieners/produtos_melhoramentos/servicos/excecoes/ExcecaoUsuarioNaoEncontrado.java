package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes;

public class ExcecaoUsuarioNaoEncontrado  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcecaoUsuarioNaoEncontrado (String mensagem) {
        super(mensagem);
    }

}
