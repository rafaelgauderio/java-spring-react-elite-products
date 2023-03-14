package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;

@Service
public class EmbalagemServico {
	
	@Autowired
	private EmbalagemRepositorio embalagemRepositorio;
	
	@Transactional(readOnly=true)
	public List<EmbalagemDTO> buscarTodas() {
		List <Embalagem> listaDeEmbalagem = new ArrayList<Embalagem>();
		listaDeEmbalagem = embalagemRepositorio.findAll();
		return listaDeEmbalagem.stream().map(e -> new EmbalagemDTO(e)).collect(Collectors.toList());
	}

}
