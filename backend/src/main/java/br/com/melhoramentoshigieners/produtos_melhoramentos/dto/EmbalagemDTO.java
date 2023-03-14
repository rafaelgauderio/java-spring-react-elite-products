package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;

public class EmbalagemDTO {
	
	// DTO = Data Transfer Object
	// agiliza a comunicação. Ao invés de passar cada atributo individualmente, transfere apenas os atributos necessários em um 
	// objeto único
	
	private Long id;
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
