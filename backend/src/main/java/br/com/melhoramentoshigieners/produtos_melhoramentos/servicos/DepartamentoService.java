package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.DepartamentoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Departamento;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.DepartamentoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepositorio repositorio;

	@Transactional(readOnly = true)
	public List<DepartamentoDTO> findAll() {

		List<Departamento> listaDepartamento = repositorio.findAll();
		// convertendo de lista para map, aplicando um função e reconvertendo para lista
		return listaDepartamento.stream().map(dep -> new DepartamentoDTO(dep)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public DepartamentoDTO findById(Long id) {
		Optional<Departamento> optinal = repositorio.findById(id);
		Departamento departamento = optinal
				.orElseThrow(() -> new ExcecaoEntidadeNaoEncontrada("Departamento não encontrado com a id informada!"));
		return new DepartamentoDTO(departamento);
	}

	@Transactional(readOnly = false)
	public DepartamentoDTO insert(DepartamentoDTO dto) {
		Departamento entidade = new Departamento();
		entidade.setNome(dto.getNome());
		entidade = repositorio.save(entidade);
		return new DepartamentoDTO(entidade);
	}

	@Transactional(readOnly = false)
	public DepartamentoDTO update(Long id, DepartamentoDTO dto) {

		try {
			Departamento entidade = repositorio.getReferenceById(id);
			entidade.setNome(dto.getNome());
			entidade = repositorio.save(entidade);
			return new DepartamentoDTO(entidade);
		} catch (EntityNotFoundException erro) {

			throw new ExcecaoEntidadeNaoEncontrada("Departamento não encontrado com id de número: " + id);
		}
	}

	public void delete(Long departamentoId) {
		try {
			repositorio.deleteById(departamentoId);
		} catch (EmptyResultDataAccessException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Departamento não encontrado com id de número: " + departamentoId);
		} catch (DataIntegrityViolationException erro) {
			throw new ExcecaoIntegridadeBancoDeDados(
					"Não é possivel excluir um departamento que já tem um colaborador cadastrado.");
		}

	}

}
