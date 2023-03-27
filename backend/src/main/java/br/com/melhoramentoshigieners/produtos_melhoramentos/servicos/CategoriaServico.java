package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Transactional(readOnly= true)
	public Page<CategoriaDTO> buscarTodas (Pageable requisicaoPaginada) {
		Page<Categoria> listaPaginadaDeCategoria = categoriaRepositorio.findAll(requisicaoPaginada);		
		return  listaPaginadaDeCategoria.map(cat -> new CategoriaDTO(cat));
			
	}
	
	@Transactional(readOnly=true)
	public CategoriaDTO byscarPorId (Long id) {
		Optional<Categoria> optionalDeCategoria = categoriaRepositorio.findById(id);
		//Categoria categoria = optionalDeCategoria.get();
		Categoria categoria = optionalDeCategoria.orElseThrow(() -> new ExcecaoEntidadeNaoEncontrada("Categoria não encontrada com o id de número " + id));
		CategoriaDTO dto = new CategoriaDTO(categoria);
		return dto;		
	}
	
	@Transactional(readOnly=false)
	public CategoriaDTO inserir(CategoriaDTO dto) {
		Categoria entidade = new Categoria();
		entidade.setDescricao(dto.getDescricao());
		entidade = categoriaRepositorio.save(entidade);
		CategoriaDTO categoriaDTO = new CategoriaDTO(entidade);
		return categoriaDTO;
	}
	
	@Transactional(readOnly=false)
	public CategoriaDTO atualizar(Long id, CategoriaDTO dto) {
		try {
			Categoria entidade = categoriaRepositorio.getOne(id);
			entidade.setDescricao(dto.getDescricao());
			entidade = categoriaRepositorio.save(entidade);
			CategoriaDTO categoriaDTO = new CategoriaDTO(entidade);
			return categoriaDTO;
		} catch (EntityNotFoundException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Categoria não encontrada com o id de número " + id);
		}	
	}
	

	public void delete(Long id) {
		try {
			categoriaRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Categoria não encontrada com o id de número " + id);
		} catch (DataIntegrityViolationException erro) {
			throw new ExcecaoIntegridadeBancoDeDados(
					"Não é possivel excluir uma categoria já relacionada com outra Entidade");
		} //finally {
			//throw new ExcecaoEntidadeNaoEncontrada("Categoria não encontrada com o id de número " + id);
			//throw new ExcecaoIntegridadeBancoDeDados("Não é possivel excluir uma categoria já relacionada com outra Entidade");
		//}

	}

}
