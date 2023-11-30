package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import org.springframework.web.multipart.MultipartFile;

public class ArquivoDTO {
	
	private MultipartFile arquivo;
	
	public ArquivoDTO() {
		
	}
	public ArquivoDTO(MultipartFile arquivo) {		
		this.arquivo = arquivo;
	}
	public MultipartFile getArquivo() {
		return arquivo;
	}
	public void setArquivo(MultipartFile arquivo) {
		this.arquivo = arquivo;
	}
	
	

}
