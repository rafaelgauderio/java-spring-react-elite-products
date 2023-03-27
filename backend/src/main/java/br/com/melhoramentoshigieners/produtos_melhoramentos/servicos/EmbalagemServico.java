package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;

import javax.persistence.EntityNotFoundException;


@Service
public class EmbalagemServico {

	@Autowired
	private EmbalagemRepositorio embalagemRepositorio;

	@Transactional(readOnly = true)
	public Page<EmbalagemDTO> buscarTodas(Pageable requisicaoPaginada) {
		Page<Embalagem> listaPaginadaDeEmbalagem = embalagemRepositorio.findAll(requisicaoPaginada);		
		return listaPaginadaDeEmbalagem.map(emb -> new EmbalagemDTO(emb));
	}

	// método para buscar Embalagem pelo id
	@Transactional(readOnly = true)
	public EmbalagemDTO buscarPorId(Long id) {
		Optional<Embalagem> optionalDeEmbalagem = embalagemRepositorio.findById(id);
		// Embalagem embalagem = optionalDeEmbalagem.get();
		// vai disparar excecao senao informar um id inexistente
		Embalagem embalagem = optionalDeEmbalagem.orElseThrow(
				() -> new ExcecaoEntidadeNaoEncontrada("Embalagem não encontrada com o id de número " + id));
		EmbalagemDTO embalagemDTO = new EmbalagemDTO(embalagem);
		return embalagemDTO;

	}

	@Transactional(readOnly = false)
	public EmbalagemDTO inserir(EmbalagemDTO dto) {
		Embalagem entidade = new Embalagem();
		entidade.setDescricao(dto.getDescricao());
		entidade = embalagemRepositorio.save(entidade);
		EmbalagemDTO embalagemDTO = new EmbalagemDTO(entidade);
		return embalagemDTO;
	}

	@Transactional(readOnly = false)
	public EmbalagemDTO atualizar(Long id, EmbalagemDTO dto) {
		try {
			Embalagem entidade = embalagemRepositorio.getOne(id);
			entidade.setDescricao(dto.getDescricao());
			entidade = embalagemRepositorio.save(entidade);
			EmbalagemDTO embalagemDTO = new EmbalagemDTO(entidade);
			return embalagemDTO;
		} catch (EntityNotFoundException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Embalagem não encontrada com o id de número " + id);
		}
	}


	public void delete(Long id) {
		// podem estourar 2 tipos e exceções.
		// Senão tiver embalgem com o id informado ou se já tiver algum produto
		// cadastrado relacionada com essa embalagem
		// daria um erro de violação de integridade de database

		try {
			embalagemRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Embalagem não encontrada com o id de número " + id);
		} catch (DataIntegrityViolationException erro) {
			throw new ExcecaoIntegridadeBancoDeDados(
					"Não é possivel excluir uma embalagem já relacionada com outra Entidade");
		}

	}

}
