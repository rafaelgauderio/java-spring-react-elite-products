package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SmsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@Column(unique=true)
	@NotBlank(message="Obrigatório preencher o campo telefone")
	@Size(min=6, max = 15, message="telefone deve ter entre 6 e 15 caracteres")
	private String telefone;

	private String mensagem;

	public SmsDTO() {

	}
		

	public SmsDTO(Long id, String telefone, String mensagem) {		
		this.id = id;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}
	
	public SmsDTO (SmsDTO entity) {		
		telefone = entity.getTelefone();		
	};


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
