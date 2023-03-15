package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes;

import java.io.Serializable;
import java.time.Instant;

public class ExcecaoCustomizada implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	private String nomeDoErro;
	private String menssagemDeErro;
	private String caminho;
	private Integer codigoHttpDoErro;
	private Instant momentoDoErro;
	
	public ExcecaoCustomizada () {
		
	}

	public ExcecaoCustomizada(String nomeDoErro, String menssagemDeErro, String caminho, Integer codigoHttpDoErro, Instant momentoDoErro) {
		
		this.nomeDoErro = nomeDoErro;
		this.menssagemDeErro = menssagemDeErro;
		this.caminho = caminho;
		this.codigoHttpDoErro = codigoHttpDoErro;
		this.momentoDoErro = momentoDoErro;
	}

	public String getNomeDoErro() {
		return nomeDoErro;
	}

	public void setNomeDoErro(String nomeDoErro) {
		this.nomeDoErro = nomeDoErro;
	}

	public String getMenssagemDeErro() {
		return menssagemDeErro;
	}

	public void setMenssagemDeErro(String menssagemDeErro) {
		this.menssagemDeErro = menssagemDeErro;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Integer getcodigoHttpDoErro() {
		return codigoHttpDoErro;
	}

	public void setCodigoHttpDoErro(Integer codigoHttpDoErro) {
		this.codigoHttpDoErro = codigoHttpDoErro;
	}

	public Instant getMomentoDoErro() {
		return momentoDoErro;
	}

	public void setMomentoDoErro(Instant momentoDoErro) {
		this.momentoDoErro = momentoDoErro;
	}

}
