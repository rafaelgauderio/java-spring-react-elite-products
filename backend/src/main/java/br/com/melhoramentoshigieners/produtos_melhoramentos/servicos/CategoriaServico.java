package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Transactional(readOnly= true)
	public List<CategoriaDTO> buscarTodas () {
		List<Categoria> listaDeCategoria = new ArrayList<Categoria>();
		listaDeCategoria = categoriaRepositorio.findAll();
		// convertendo de lista de Categoria para um lista de CategoriaDTO
		List<CategoriaDTO> dto = listaDeCategoria.stream().map(c -> new CategoriaDTO(c)).collect(Collectors.toList());
		return dto;		
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
			Categoria entidade = categoriaRepositorio.getReferenceById(id);
			entidade.setDescricao(dto.getDescricao());
			entidade = categoriaRepositorio.save(entidade);
			CategoriaDTO categoriaDTO = new CategoriaDTO(entidade);
			return categoriaDTO;
		} catch (ExcecaoEntidadeNaoEncontrada erro) {			
			throw new ExcecaoEntidadeNaoEncontrada("Categoria não encontrada com o id de número " + id);
		}	
	}

}
