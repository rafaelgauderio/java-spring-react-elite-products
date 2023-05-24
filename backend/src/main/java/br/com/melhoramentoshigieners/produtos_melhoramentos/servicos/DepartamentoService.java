package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.DepartamentoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Departamento;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.DepartamentoRepositorio;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepositorio repositorio;
	
	@Transactional(readOnly=true)
	public List<DepartamentoDTO> findAll () {
		
		List<Departamento> listaDepartamento = repositorio.findAll();
		// convertendo de lista para map, aplicando um função e reconvertendo para lista
		return listaDepartamento.stream().map(dep -> new DepartamentoDTO(dep)).collect(Collectors.toList());		
	}
	
	

}
