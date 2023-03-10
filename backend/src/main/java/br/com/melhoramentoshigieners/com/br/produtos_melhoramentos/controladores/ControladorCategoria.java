package br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.entidades.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class ControladorCategoria {
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodas () {
		List<Categoria> listDeCategorias = new ArrayList<Categoria>();
		
		listDeCategorias.add(new Categoria(1L, "Papel Toalha"));
		listDeCategorias.add(new Categoria(2L, "Papel Higiênico"));
		listDeCategorias.add(new Categoria(2L, "Guardanapo"));
		listDeCategorias.add(new Categoria(3L, "Interfolhado"));
		listDeCategorias.add(new Categoria(4L, "Rolo"));
		listDeCategorias.add(new Categoria(5L, "Excellence"));
		listDeCategorias.add(new Categoria(6L, "Plus"));
		listDeCategorias.add(new Categoria(7L, "Classic"));
		
		return ResponseEntity.ok().body(listDeCategorias);
	}

}
