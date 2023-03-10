package br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.entidades;

import br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.entidades.enumerados.Permissao;

public class Regra {

	private Long id;
	private String descricao;
	private Permissao permissao;
	
	public Regra() {

	}

	public Regra(Long id, String descricao, Permissao permissao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.permissao = permissao;
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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
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
