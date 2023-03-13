package br.com.melhoramentoshigieners.produtos_melhoramentos.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Categoria implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private Set<Produto> produtos = new HashSet<Produto>();
	
	public Categoria () {
		
	}

	public Categoria(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
	

	public Set<Produto> getProdutos() {
		return produtos;
	}
	
	/* não se usa método set para coleções.
	 * se adiciona ou remove por métodos add e remove.	 
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	*/

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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
