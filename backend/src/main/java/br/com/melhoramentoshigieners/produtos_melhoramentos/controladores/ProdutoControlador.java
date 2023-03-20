package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControlador {

    @Autowired
    private ProdutoServico servico;

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> buscarTodosProdutos (Pageable requisicaoPaginada) {
        Page listaPaginadaDeProdutos = servico.buscarTodos(requisicaoPaginada);
        return ResponseEntity.ok().body(listaPaginadaDeProdutos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produtoDTO = servico.buscarPorId(id);
        return ResponseEntity.ok().body(produtoDTO);

    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> inserirProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = servico.inserir(produtoDTO);
        URI identificador = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDTO.getId()).toUri();
        return ResponseEntity.created(identificador).body(produtoDTO);
    }



}
