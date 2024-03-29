package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UriDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ProdutoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;

@Service
public class ProdutoServico {

	@Autowired
	private CategoriaRepositorio repositorioDeCategorias;

	@Autowired
	private EmbalagemRepositorio repositorioDeEmbalagens;

	@Autowired
	private ProdutoRepositorio repositorioDeProdutos;

	@Autowired
	private AwsS3Servico awsS3Servico;

	// funcao trim para tirar os espaços em brancos
	@Transactional(readOnly = true)
	public Page<ProdutoDTO> buscarTodos(Long embalagemId, Long categoriaId, String descricao,
			Pageable requisicaoPaginada) {
		List<Embalagem> listaDeEmbalagens = (embalagemId == 0) ? null
				: Arrays.asList(repositorioDeEmbalagens.getReferenceById(embalagemId));
		List<Categoria> listaDeCategorias = (categoriaId == 0) ? null
				: Arrays.asList(repositorioDeCategorias.getReferenceById(categoriaId));
		Page<Produto> listaPaginadaDeProdutos = repositorioDeProdutos.buscarProdutosPorEmbalagemECategoria(
				listaDeEmbalagens, listaDeCategorias, descricao.trim(), requisicaoPaginada);
		repositorioDeProdutos.buscarProdutosComEmbalgensECategorias(listaPaginadaDeProdutos.getContent());
		return listaPaginadaDeProdutos.map(p -> new ProdutoDTO(p, p.getEmbalagens(), p.getCategorias()));
	}

	@Transactional(readOnly = true)
	public ProdutoDTO buscarPorId(Long id) {
		Optional<Produto> optionalProduto = repositorioDeProdutos.findById(id);
		Produto entidade = optionalProduto.orElseThrow(
				() -> new ExcecaoEntidadeNaoEncontrada("Produto não foi encontrado com o id de número " + id));
		ProdutoDTO dto = new ProdutoDTO(entidade, entidade.getEmbalagens(), entidade.getCategorias());
		return dto;
	}

	@Transactional(readOnly = false)
	public ProdutoDTO inserir(ProdutoDTO produtoDTO) {
		Produto entidade = new Produto();
		entidade.setDescricao(produtoDTO.getDescricao());
		entidade.setDescricaoCompleta(produtoDTO.getDescricaoCompleta());
		entidade.setPreco(produtoDTO.getPreco());
		entidade.setLargura(produtoDTO.getLargura());
		entidade.setMetragem(produtoDTO.getMetragem());
		entidade.setPeso(produtoDTO.getPeso());
		entidade.setFragrancia(produtoDTO.getFragrancia());
		entidade.setImgUrl(produtoDTO.getImgUrl());
		entidade.setDataCadastro(produtoDTO.getDataCadastro());

		// percorrendo toda a coleção de embalagens e adicionado no entidade Produto
		// entidade.getEmbalagens().clear();
		for (EmbalagemDTO embDTO : produtoDTO.getEmbalagens()) {
			Embalagem embalagem = repositorioDeEmbalagens.getReferenceById(embDTO.getId());
			entidade.getEmbalagens().add(embalagem);
		}

		// percorrendo toda a coleção de categorias e adicionado no entidade Produto
		// entidade.getCategorias().clear();
		for (CategoriaDTO catDTO : produtoDTO.getCategorias()) {
			Categoria categoria = repositorioDeCategorias.getReferenceById(catDTO.getId());
			entidade.getCategorias().add(categoria);
		}

		entidade = repositorioDeProdutos.save(entidade);
		return new ProdutoDTO(entidade, entidade.getEmbalagens(), entidade.getCategorias());
	}

	@Transactional(readOnly = false)
	public ProdutoDTO update(Long id, ProdutoDTO produtoDTO) {

		try {
			Produto entidade = repositorioDeProdutos.getReferenceById(id);
			entidade.setDescricao(produtoDTO.getDescricao());
			entidade.setDescricaoCompleta(produtoDTO.getDescricaoCompleta());
			entidade.setPreco(produtoDTO.getPreco());
			entidade.setLargura(produtoDTO.getLargura());
			entidade.setMetragem(produtoDTO.getMetragem());
			entidade.setPeso(produtoDTO.getPeso());
			entidade.setFragrancia(produtoDTO.getFragrancia());
			entidade.setImgUrl(produtoDTO.getImgUrl());
			entidade.setDataCadastro(produtoDTO.getDataCadastro());

			entidade.getEmbalagens().clear();
			for (EmbalagemDTO embDTO : produtoDTO.getEmbalagens()) {
				Embalagem embalagem = repositorioDeEmbalagens.getReferenceById(embDTO.getId());
				entidade.getEmbalagens().add(embalagem);
			}

			entidade.getCategorias().clear();
			for (CategoriaDTO catDTO : produtoDTO.getCategorias()) {
				Categoria categoria = repositorioDeCategorias.getReferenceById(catDTO.getId());
				entidade.getCategorias().add(categoria);
			}

			entidade = repositorioDeProdutos.save(entidade);
			ProdutoDTO dto = new ProdutoDTO(entidade, entidade.getEmbalagens(), entidade.getCategorias());
			return dto;

		} catch (EntityNotFoundException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Não foi encontrado o produto com id de número " + id);
		}

	}

	public void deleteById(Long id) {
		try {
			repositorioDeProdutos.deleteById(id);
		} catch (EmptyResultDataAccessException erro) {
			throw new ExcecaoEntidadeNaoEncontrada("Produto de id de núemro " + id + " não encontrado");
		} catch (DataIntegrityViolationException erro) {
			throw new ExcecaoIntegridadeBancoDeDados(
					"Não é possível excluir um produto referenciado em outras entidades");
		}
	}

	@Transactional(readOnly = false)
	public UriDTO uploadArquivo(MultipartFile arquivo) {

		URL url = awsS3Servico.uploadFile(arquivo);
		UriDTO uriDTO = new UriDTO(url.toString());

		return uriDTO;
	}

}