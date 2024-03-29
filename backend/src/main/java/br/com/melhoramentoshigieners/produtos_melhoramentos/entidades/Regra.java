package br.com.melhoramentoshigieners.produtos_melhoramentos.entidades;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.enumerados.Permissao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_regra")
public class Regra implements Serializable {

	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;

	@NotBlank
	private String permissao;

	@ManyToMany(mappedBy = "regras")
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Regra() {

	}

	public Regra(Long id, String descricao, Permissao permissao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.permissao = permissao.getValue();
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

	public void setDescricao(Permissao descricao) {
		this.descricao = descricao.getValue();
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao.getValue();
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regra other = (Regra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		
	

}
