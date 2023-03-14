package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;

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

}
