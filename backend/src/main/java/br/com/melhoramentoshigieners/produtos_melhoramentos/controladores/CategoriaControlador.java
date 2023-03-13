package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.CategoriaServico;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaControlador {
	
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodas () {
		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
		listaDeCategorias = servico.buscarTodas();		
		return ResponseEntity.ok().body(listaDeCategorias);
	}

}
