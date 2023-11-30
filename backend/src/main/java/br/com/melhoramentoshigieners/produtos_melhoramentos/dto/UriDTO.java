package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

// corpo da reposta com a url do imagem enviada
public class UriDTO implements  Serializable {	
	
	private static final long serialVersionUID = 1L;	
	
	private String uri;
	
	public UriDTO () {
		
	}

	public UriDTO(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}	

}
