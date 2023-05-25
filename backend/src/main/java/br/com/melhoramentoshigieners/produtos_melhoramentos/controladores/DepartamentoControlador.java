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

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.DepartamentoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.DepartamentoService;

@RestController
@RequestMapping(value = "departamentos")
public class DepartamentoControlador {

	@Autowired
	private DepartamentoService service;

	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> buscarTodosDepartamentos() {
		List<DepartamentoDTO> listaDepartamentoDTO = service.findAll();
		return ResponseEntity.ok().body(listaDepartamentoDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartamentoDTO> buscarDepartamentoPorId(@PathVariable Long id) {
		DepartamentoDTO departamentoDTO = service.findById(id);
		return ResponseEntity.ok().body(departamentoDTO);
	}

	@PostMapping
	public ResponseEntity<DepartamentoDTO> inserirDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
		departamentoDTO = service.insert(departamentoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(departamentoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(departamentoDTO);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<DepartamentoDTO> atualizarDepartamento(@PathVariable Long id,
			@RequestBody DepartamentoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleterDepartamento(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
