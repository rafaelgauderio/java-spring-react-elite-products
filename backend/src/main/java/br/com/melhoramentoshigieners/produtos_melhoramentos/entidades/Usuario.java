package br.com.melhoramentoshigieners.produtos_melhoramentos.entidades;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String password;
	private Set<Regra> regras = new HashSet<Regra> ();
	
	public Usuario () {
		
	}

	public Usuario(Long id, String nome, String sobrenome, String email, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Regra> getRegras() {
		return regras;
	}
	

	/*
	public void setRegras(Set<Regra> regras) {
		this.regras = regras;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}
