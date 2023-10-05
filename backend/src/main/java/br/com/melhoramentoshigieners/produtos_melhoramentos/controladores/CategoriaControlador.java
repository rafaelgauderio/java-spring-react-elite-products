package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.CategoriaServico;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControlador {

	@Autowired
	private CategoriaServico servico;

	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> buscarTodas(
			@PageableDefault(sort = "descricao", direction = Sort.Direction.ASC) Pageable requisicaoPaginada) {
		Page<CategoriaDTO> listaPaginadaDeCategorias = new PageImpl<>(new ArrayList<CategoriaDTO>());
		listaPaginadaDeCategorias = servico.buscarTodas(requisicaoPaginada);
		return ResponseEntity.ok().body(listaPaginadaDeCategorias);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
		CategoriaDTO categoriaDTO = servico.byscarPorId(id);
		return ResponseEntity.ok().body(categoriaDTO);

	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> inserirCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		categoriaDTO = servico.inserir(categoriaDTO);
		URI identificador = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriaDTO.getId()).toUri();
		return ResponseEntity.created(identificador).body(categoriaDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id,
			@Valid @RequestBody CategoriaDTO categoriaDTO) {
		categoriaDTO = servico.atualizar(id, categoriaDTO);
		return ResponseEntity.ok().body(categoriaDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarCategoriaPorId(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

}
