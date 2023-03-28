package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes;

import java.util.Vector;

public class ExcecaoDeValidacao extends ExcecaoCustomizada {

    private static final long serialVersionUID = 1L;

    private Vector<CamposDeValidacao> errosDeValidacao = new Vector<CamposDeValidacao>();

    public Vector<CamposDeValidacao> getErrosDeValidacao() {
        return errosDeValidacao;
    }

    /* Não usar set para coleções. Adicionar e remover via método add e remove
    public void setErrosDeValidacao(Vector<CamposDeValidacao> errosDeValidacao) {
        this.errosDeValidacao = errosDeValidacao;
    }
     */

    public void adicionarErro(String nomeDoCampo, String mensagem) {
        CamposDeValidacao camposDeValidacao = new CamposDeValidacao(nomeDoCampo, mensagem);
        errosDeValidacao.add(camposDeValidacao);
    }
}
