package br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.entidades.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.entidades.Embalagem;

@RestController
@RequestMapping(value = "/embalagens")
public class ControladorEmbalagem {
	
	@GetMapping
	public ResponseEntity<List<Embalagem>> buscarTodas () {
		List<Embalagem> listDeEmbalagens = new ArrayList<Embalagem>();
		
		listDeEmbalagens.add(new Embalagem(1L, "Galão de 2 Litros"));
		listDeEmbalagens.add(new Embalagem(2L, "Galão de 5 Litros"));
		listDeEmbalagens.add(new Embalagem(3L, "Bombona de 20 Litros"));
		listDeEmbalagens.add(new Embalagem(4L, "Fardo com 8 rolos"));
		listDeEmbalagens.add(new Embalagem(5L, "Fardo com 4 rolos"));
		listDeEmbalagens.add(new Embalagem(6L, "2.400 metros"));
		listDeEmbalagens.add(new Embalagem(7L, "2.000 metros"));
		
		return ResponseEntity.ok().body(listDeEmbalagens);
	}

}
