package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> buscarUsuarios(Pageable requisicaoPaginada) {
        Page<UsuarioDTO> listaPaginadaDeUsuarios = usuarioServico.buscarTodos(requisicaoPaginada);
        return ResponseEntity.ok().body(listaPaginadaDeUsuarios);
    }
}
