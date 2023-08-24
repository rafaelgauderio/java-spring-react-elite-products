package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControlador {

    @Autowired
    private ProdutoServico servico;

    @SuppressWarnings("unchecked")
	@GetMapping
    public ResponseEntity<Page<ProdutoDTO>> buscarTodosProdutos (
            @RequestParam(value = "embalagemId", defaultValue = "0") Long embalagemId,
            @RequestParam(value="categoriaId", defaultValue = "0") Long categoriaId,
            @RequestParam(value = "descricao", defaultValue = "") String descricao,
            @PageableDefault(sort= "descricao", direction= Sort.Direction.ASC
            )
            Pageable requisicaoPaginada) {
        @SuppressWarnings("rawtypes")
		Page listaPaginadaDeProdutos = servico.buscarTodos(embalagemId, categoriaId,descricao, requisicaoPaginada);
        return ResponseEntity.ok().body(listaPaginadaDeProdutos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produtoDTO = servico.buscarPorId(id);
        return ResponseEntity.ok().body(produtoDTO);

    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> inserirProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = servico.inserir(produtoDTO);
        URI identificador = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDTO.getId()).toUri();
        return ResponseEntity.created(identificador).body(produtoDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id,@Valid @RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = servico.update(id, produtoDTO);
        return ResponseEntity.ok().body(produtoDTO);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        servico.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
