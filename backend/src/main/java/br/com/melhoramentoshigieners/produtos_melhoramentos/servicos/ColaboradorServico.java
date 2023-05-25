package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ColaboradorDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Colaborador;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Departamento;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ColaboradorRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.DepartamentoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;

@Service
public class ColaboradorServico {
	
	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	@Autowired
	private DepartamentoRepositorio departamentoRepositorio;
	
	@Transactional(readOnly=true)
	public List<ColaboradorDTO> findAll() {
		List <Colaborador> listaColaborador = colaboradorRepositorio.findAll();
		return listaColaborador.stream().map(col -> new ColaboradorDTO(col)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly=true)
	public ColaboradorDTO findById(Long colaboradorId) {		
		Optional<Colaborador> optional = colaboradorRepositorio.findById(colaboradorId);
		Colaborador entidade = optional.orElseThrow(() -> new ExcecaoEntidadeNaoEncontrada("Colaborador não encontrado com id de número: " + colaboradorId));
		return new ColaboradorDTO(entidade);
	}
	
	@Transactional(readOnly=true)
	public ColaboradorDTO insert(ColaboradorDTO colaboradorDTO) {
		Colaborador entidade = new Colaborador();
		entidade.setNome(colaboradorDTO.getNome());
		entidade.setEmail(colaboradorDTO.getEmail());
		entidade.setTelefone(colaboradorDTO.getTelefone());		
		
		Departamento departamento = new Departamento();
		departamento.setId(colaboradorDTO.getDepartamentoId());
		entidade.setDepartamento(departamento);
			
		entidade = colaboradorRepositorio.save(entidade);
		
		return new ColaboradorDTO(entidade);
	}

}
