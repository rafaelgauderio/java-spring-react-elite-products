package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.EmbalagemServico;

@RestController
@RequestMapping(value = "/embalagens")
public class EmbalagemControlador {
	
	@Autowired
	private EmbalagemServico embalagemServico;
	
	@GetMapping
	public ResponseEntity<List<EmbalagemDTO>> buscarTodas () {
		List<EmbalagemDTO> listaDeEmbalagens = new ArrayList<EmbalagemDTO>();
		listaDeEmbalagens = embalagemServico.buscarTodas();		
		return ResponseEntity.ok().body(listaDeEmbalagens);
	}

}
