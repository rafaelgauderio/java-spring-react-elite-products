package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Transactional(readOnly= true)
	public List<Categoria> buscarTodas () {
		List<Categoria> listaDeCategoria = new ArrayList<Categoria>();
		listaDeCategoria = categoriaRepositorio.findAll();
		return listaDeCategoria;		
	}

}
