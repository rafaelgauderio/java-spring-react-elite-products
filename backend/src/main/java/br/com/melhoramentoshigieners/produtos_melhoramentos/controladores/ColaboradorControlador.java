package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ColaboradorDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ColaboradorServico;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorControlador {
	
	@Autowired
	private ColaboradorServico service;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> buscarTodosColaboradores() {
		List<ColaboradorDTO> listColaborador = service.findAll();
		return ResponseEntity.ok().body(listColaborador);
	}	

}
