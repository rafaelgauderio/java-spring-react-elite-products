package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.RegraDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Regra;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.RegraRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.UsuarioRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio repositorioDeUsuario;

    @Autowired
    private RegraRepositorio regraRepositorio;

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> buscarTodos(Pageable requisicaoPaginada) {
        Page<Usuario> listaPaginadaDeUsuarios = repositorioDeUsuario.findAll(requisicaoPaginada);
        return listaPaginadaDeUsuarios.map(u -> new UsuarioDTO(u));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO buscarPorId(Long id) {
        Optional<Usuario> optinalUsuario = repositorioDeUsuario.findById(id);
        Usuario entidade = optinalUsuario.orElseThrow(
                () -> new ExcecaoEntidadeNaoEncontrada("Usupario não encontrado com o id de número " + id)
        );
        return new UsuarioDTO(entidade);
    }

    @Transactional(readOnly = false)
    public UsuarioDTO inserir(UsuarioDTO usuarioDTO) {

        Usuario entidade = new Usuario();
        entidade.setNome(usuarioDTO.getNome());
        entidade.setSobrenome(usuarioDTO.getSobrenome());
        entidade.setEmail(usuarioDTO.getEmail());

        for (RegraDTO regra : usuarioDTO.getRegras()) {
            Regra entidadeRegra = regraRepositorio.getReferenceById(regra.getId());
            entidade.getRegras().add(entidadeRegra);
        }

        entidade = repositorioDeUsuario.save(entidade);
        return new UsuarioDTO(entidade);
    }

    @Transactional(readOnly = false)
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        try {
            Usuario entidade = repositorioDeUsuario.getReferenceById(id);
            entidade.setNome(usuarioDTO.getNome());
            entidade.setSobrenome(usuarioDTO.getSobrenome());
            entidade.setEmail(usuarioDTO.getEmail());

            entidade.getRegras().clear();

            for (RegraDTO regra : usuarioDTO.getRegras()) {
                Regra entidadeRegra = regraRepositorio.getReferenceById(regra.getId());
                entidade.getRegras().add(entidadeRegra);
            }

            entidade = repositorioDeUsuario.save(entidade);
            return new UsuarioDTO(entidade);

        } catch (EntityNotFoundException erro) {
            throw new ExcecaoEntidadeNaoEncontrada("Não foi encontrado usuário com o id de número " + id);
        }


    }
}
