package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.RegraRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio repositorioDeUsuario;

    @Autowired
    private RegraRepositorio regraRepositorio;

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> buscarTodos(Pageable requisicaoPaginada) {
        Page<Usuario> listaPaginadaDeUsuarios = repositorioDeUsuario.findAll(requisicaoPaginada);
        return listaPaginadaDeUsuarios.map( u -> new UsuarioDTO(u));
    }
}
