package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.RegraDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioPasswordDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Regra;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.RegraRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @GetMapping(value="/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO dto = usuarioServico.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserirUsuario (@Valid @RequestBody UsuarioPasswordDTO usuarioPasswordDTO) {

        UsuarioDTO usuarioDTO = usuarioServico.inserir(usuarioPasswordDTO);
        URI identificador = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                usuarioDTO.getId()).toUri();
        return ResponseEntity.created(identificador).body(usuarioDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id,@Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = usuarioServico.update(id, usuarioDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioServico.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}