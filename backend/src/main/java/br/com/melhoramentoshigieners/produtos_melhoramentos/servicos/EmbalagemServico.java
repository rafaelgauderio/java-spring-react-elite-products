package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;

@Service
public class EmbalagemServico {
	
	@Autowired
	private EmbalagemRepositorio embalagemRepositorio;
	
	@Transactional(readOnly=true)
	public List<Embalagem> buscarTodas() {
		return embalagemRepositorio.findAll();
	}

}
