package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;

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
	
	// método para buscar Embalagem pelo id
	@Transactional(readOnly=true)
	public EmbalagemDTO buscarPorId(Long id) {
		Optional<Embalagem> optionalDeEmbalagem = embalagemRepositorio.findById(id);
		//Embalagem embalagem = optionalDeEmbalagem.get();
		// vai disparar excecao senao informar um id inexistente
		Embalagem embalagem = optionalDeEmbalagem.orElseThrow(() -> new ExcecaoEntidadeNaoEncontrada("Embalagem não encontrada com o id de número " + id));
		EmbalagemDTO embalagemDTO = new EmbalagemDTO(embalagem);
		return embalagemDTO; 
		
	}

}
