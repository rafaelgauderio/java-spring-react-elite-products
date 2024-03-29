package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Colaborador;

public class ColaboradorDTO  implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String departamentoNome;
	private Long departamentoId;
	
	public ColaboradorDTO () {
				
	}

	public ColaboradorDTO(Long id, String nome, String telefone, String email, Long departamentoId, String departamentoNome) {		
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.departamentoNome = departamentoNome;
		this.departamentoId = departamentoId;
	}
	
	public ColaboradorDTO(Colaborador entity) {
		id = entity.getId();
		nome = entity.getNome();
		telefone = entity.getTelefone();
		email = entity.getEmail();
		departamentoNome = entity.getDepartamento().getNome();
		departamentoId = entity.getDepartamento().getId();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}

	public String getDepartamentoNome() {
		return departamentoNome;
	}

	public void setDepartamentoNome(String departamentoNome) {
		this.departamentoNome = departamentoNome;
	}		
	

}
