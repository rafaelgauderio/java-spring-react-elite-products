package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoriaDTO implements Serializable {			
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

	@Column(unique=true)
	@NotBlank(message="Obrigatório preencher o nome da categoria")
	@Size(min=3, max = 30, message="Campo categoria deve ter entre 3 e 30 caracteres")
	private String descricao;
	
	public CategoriaDTO () {
		
	}

	public CategoriaDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public CategoriaDTO(Categoria entidade) {
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
