package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ColaboradorDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ColaboradorServico;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorControlador {

	@Autowired
	private ColaboradorServico servico;

	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> buscarTodosColaboradores() {
		List<ColaboradorDTO> listColaborador = servico.findAll();
		return ResponseEntity.ok().body(listColaborador);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<ColaboradorDTO> buscarColaboradorPorId(@PathVariable Long id) {
		ColaboradorDTO dto = servico.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<ColaboradorDTO> inserirColaborador(@RequestBody ColaboradorDTO dto) {
		dto = servico.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getDepartamentoNome())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ColaboradorDTO> atualizarColaborador(@PathVariable Long id, @RequestBody ColaboradorDTO dto) {
		dto = servico.update(id, dto);
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluiColaborador(@PathVariable Long id) {
		servico.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
