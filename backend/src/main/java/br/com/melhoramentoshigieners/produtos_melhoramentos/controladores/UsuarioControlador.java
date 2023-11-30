package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.*;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value="/email")
    public ResponseEntity<UsuarioDTO> buscarUSuarioPorEmail(@RequestBody UsuarioDTO dto) {
       UsuarioDTO newDTO = usuarioServico.buscarUsuarioPorEmail(dto);
       return ResponseEntity.ok().body(newDTO);
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
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id,@Valid @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        UsuarioDTO usuarioDTO = usuarioServico.update(id, usuarioUpdateDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioServico.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}