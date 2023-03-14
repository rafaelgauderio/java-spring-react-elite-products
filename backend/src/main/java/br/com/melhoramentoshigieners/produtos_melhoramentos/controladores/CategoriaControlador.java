package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.CategoriaServico;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaControlador {
	
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> buscarTodas () {
		List<CategoriaDTO> listaDeCategorias = new ArrayList<CategoriaDTO>();
		listaDeCategorias = servico.buscarTodas();		
		return ResponseEntity.ok().body(listaDeCategorias);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
		CategoriaDTO categoriaDTO = servico.byscarPorId(id);
		return ResponseEntity.ok().body(categoriaDTO);
		
	}

}
