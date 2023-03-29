package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes;

import java.io.Serializable;

public class CamposDeValidacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeDoCampo;
    private String mensagem;

    public CamposDeValidacao () {

    }

    public CamposDeValidacao(String nomeDoCampo, String mensagem) {
        this.nomeDoCampo = nomeDoCampo;
        this.mensagem = mensagem;
    }

    public String getNomeDoCampo() {
        return nomeDoCampo;
    }

    public void setNomeDoCampo(String nomeDoCampo) {
        this.nomeDoCampo = nomeDoCampo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
