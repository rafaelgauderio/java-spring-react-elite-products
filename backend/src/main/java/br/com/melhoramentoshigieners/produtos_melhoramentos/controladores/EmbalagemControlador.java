package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.EmbalagemServico;

@RestController
@RequestMapping(value = "/embalagens")
public class EmbalagemControlador {
	
	@Autowired
	private EmbalagemServico embalagemServico;
	
	@GetMapping
	public ResponseEntity<Page<EmbalagemDTO>> buscarTodas (Pageable requisicaoPaginada) {
		Page<EmbalagemDTO> listaPaginadaDeEmbalagens = embalagemServico.buscarTodas(requisicaoPaginada);				
		return ResponseEntity.ok().body(listaPaginadaDeEmbalagens);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<EmbalagemDTO> buscarPorId(@PathVariable Long id) {
		EmbalagemDTO embalagemDTO = embalagemServico.buscarPorId(id);
		return ResponseEntity.ok().body(embalagemDTO);
	}
	
	// retornar codigo http 201 Created
	@PostMapping
	public ResponseEntity<EmbalagemDTO> inserirEmbalagem(@RequestBody EmbalagemDTO embalagemDTO) {
		embalagemDTO = embalagemServico.inserir(embalagemDTO);
		// URI = Uniform Resource Identifier
		URI identificador = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(embalagemDTO.getId()).toUri();
		return ResponseEntity.created(identificador).body(embalagemDTO);		
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<EmbalagemDTO> atualizarEmgalagem(@PathVariable Long id, @RequestBody EmbalagemDTO embalagemDTO) {
		embalagemDTO = embalagemServico.atualizar(id, embalagemDTO);
		return ResponseEntity.ok().body(embalagemDTO);
	}
	
	// retornar codigo http 204 No Content
	// solicitação bem sucedida, mas não retorna conteudo nenhum
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarEmbalagemPorId(@PathVariable Long id) {		
		embalagemServico.delete(id);
		return ResponseEntity.noContent().build();	
	}		

}
