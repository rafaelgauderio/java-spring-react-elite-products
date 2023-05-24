package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Colaborador;

public class ColaboradorDTO  implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private Long departmentId;
	
	public ColaboradorDTO () {
				
	}

	public ColaboradorDTO(Long id, String nome, String telefone, String email, Long departmentId) {		
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.departmentId = departmentId;
	}
	
	public ColaboradorDTO(Colaborador entity) {
		id = entity.getId();
		nome = entity.getNome();
		telefone = entity.getTelefone();
		email = entity.getEmail();
		departmentId = entity.getDepartamento().getId();
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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}	
	
	

}
