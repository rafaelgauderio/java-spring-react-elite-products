package br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.enumerados;

public enum Permissao {

	ADMIN_SISTEMA("ADMIN_SISTENA"), GERENTE_LOJA("GERENTE_LOJA"), CLIENTE("CLIENTE");
	
	private String value;
	
	Permissao(String value) {
		this.value=value;
	}
	
	public String getValue () {
		return value;
	}	
	

}
