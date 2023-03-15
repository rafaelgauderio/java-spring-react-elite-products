package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> inserirCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		categoriaDTO = servico.inserir(categoriaDTO);		
		URI identificador = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoriaDTO.getId()).toUri();
		return ResponseEntity.created(identificador).body(categoriaDTO);		
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
		categoriaDTO = servico.atualizar(id, categoriaDTO);
		return ResponseEntity.ok().body(categoriaDTO);
	}

}
