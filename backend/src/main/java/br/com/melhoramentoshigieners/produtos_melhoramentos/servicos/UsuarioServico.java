package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.RegraDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioPasswordDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Regra;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.RegraRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.UsuarioRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio repositorioDeUsuario;

    @Autowired
    private RegraRepositorio regraRepositorio;

    @Autowired
    private BCryptPasswordEncoder senhaCriptografada;

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
    public UsuarioDTO inserir(UsuarioPasswordDTO usuarioPasswordDTO) {

        Usuario entidade = new Usuario();
        entidade.setNome(usuarioPasswordDTO.getNome());
        entidade.setSobrenome(usuarioPasswordDTO.getSobrenome());
        entidade.setEmail(usuarioPasswordDTO.getEmail());
        entidade.setPassword(senhaCriptografada.encode(usuarioPasswordDTO.getPassword()));

        for (RegraDTO regra : usuarioPasswordDTO.getRegras()) {
            Regra entidadeRegra = regraRepositorio.getOne(regra.getId());
            entidade.getRegras().add(entidadeRegra);
        }

        entidade = repositorioDeUsuario.save(entidade);
        return new UsuarioDTO(entidade);
    }

    @Transactional(readOnly = false)
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        try {
            Usuario entidade = repositorioDeUsuario.getOne(id);
            entidade.setNome(usuarioDTO.getNome());
            entidade.setSobrenome(usuarioDTO.getSobrenome());
            entidade.setEmail(usuarioDTO.getEmail());

            entidade.getRegras().clear();

            for (RegraDTO regra : usuarioDTO.getRegras()) {
                Regra entidadeRegra = regraRepositorio.getOne(regra.getId());
                entidade.getRegras().add(entidadeRegra);
            }

            entidade = repositorioDeUsuario.save(entidade);
            return new UsuarioDTO(entidade);

        } catch (EntityNotFoundException erro) {
            throw new ExcecaoEntidadeNaoEncontrada("Não foi encontrado usuário com o id de número " + id);
        }
    }

    public void deletarPorId(Long id) {
        try  {
            repositorioDeUsuario.deleteById(id);
        } catch(EmptyResultDataAccessException errro) {
            throw new ExcecaoEntidadeNaoEncontrada("Usuario não encontrado com id de número " + id);
        } catch(DataIntegrityViolationException erro) {
            throw new ExcecaoIntegridadeBancoDeDados("Violação de integridade de banco de dados");
        }
    }
}
