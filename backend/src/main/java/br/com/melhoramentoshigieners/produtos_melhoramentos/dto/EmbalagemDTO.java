package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmbalagemDTO implements Serializable {	

	private static final long serialVersionUID = 1L;
	// DTO = Data Transfer Object
	// agiliza a comunicação. Ao invés de passar cada atributo individualmente, transfere apenas os atributos necessários em um 
	// objeto único
	
	private Long id;

	@NotBlank(message="Obrigatório preencher o nome da embalagem")
	@Size(min=3, max = 30, message="Campo embalagem deve ter entre 3 e 30 caracteres")
	private String descricao;
	
	public EmbalagemDTO () {
		
	}

	public EmbalagemDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public EmbalagemDTO(Embalagem entidade) {
		this.id = entidade.getId();
		this.descricao = entidade.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
