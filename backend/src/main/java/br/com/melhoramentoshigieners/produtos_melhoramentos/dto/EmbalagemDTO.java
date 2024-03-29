package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes.EmbalagemValidacaoDeInsercao;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EmbalagemValidacaoDeInsercao
public class EmbalagemDTO implements Serializable {	

	private static final long serialVersionUID = 1L;
	// DTO = Data Transfer Object
	// agiliza a comunicação. Ao invés de passar cada atributo individualmente, transfere apenas os atributos necessários em um 
	// objeto único
	
	private Long id;

	@Column(unique=true)
	@NotBlank(message="Obrigatório preencher o nome da embalagem")
	@Size(min=3, max = 30, message="Campo embalagem deve ter entre 3 e 30 caracteres")
	private String descricao;
	
	public EmbalagemDTO () {
		
	}

	public EmbalagemDTO(Long id, String descricao) {
		super();		
		this.id = id;
		this.descricao = descricao.toLowerCase();
	}
	
	public EmbalagemDTO(Embalagem entidade) {
		this.id = entidade.getId();
		this.descricao = entidade.getDescricao().toLowerCase();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao.toLowerCase();
	}

	public void setDescricao(String descricao) {
		descricao = descricao.toLowerCase();
		this.descricao = descricao;
	}
	
	
	

}
