package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.DepartamentoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.DepartamentoService;

@RestController
@RequestMapping(value = "departamentos")
public class DepartamentoControlador {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping 
	public ResponseEntity<List<DepartamentoDTO>> buscarTodosDepartamentos () {
		List<DepartamentoDTO> listaDepartamentoDTO = service.findAll();
		return ResponseEntity.ok().body(listaDepartamentoDTO);		
	}

}
