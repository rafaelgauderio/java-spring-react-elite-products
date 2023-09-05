package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.servicos;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.CategoriaFactory;
import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.EmbalagemFactory;
import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.ProdutoFactory;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ProdutoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;

@ExtendWith(SpringExtension.class)
public class ProdutoServicosTests {

	// testes unitários na camada de servico
	@InjectMocks
	private ProdutoServico produtoServico;

	@Mock
	private ProdutoRepositorio produtoRepositorio;

	@Mock
	private CategoriaRepositorio categoriaRepositorio;

	@Mock
	private EmbalagemRepositorio embalagemRepositorio;

	private Long idProdutoExistente, idProdutoInexistente, idProdutoDependente;
	private Produto produto;
	private ProdutoDTO produtoDTO;
	private Embalagem embalagem;
	private Categoria categoria;
	private PageImpl<Produto> paginaDeDados;

	@BeforeEach
	void setUp() throws Exception {

		this.idProdutoExistente = 1L;
		this.idProdutoInexistente = 100L;
		this.idProdutoDependente = 2L;

		produto = ProdutoFactory.criarProduto();
		produtoDTO = ProdutoFactory.criarProdutoDTO();
		embalagem = EmbalagemFactory.criarEmbalagem();
		categoria = CategoriaFactory.criarCategoria();

		paginaDeDados = new PageImpl<>(List.of(produto));

		Mockito.when(produtoRepositorio.findAll((Pageable) ArgumentMatchers.any())).thenReturn(paginaDeDados);
		Mockito.when(produtoRepositorio.buscarProdutosPorEmbalagemECategoria(any(), any(), any(), any()))
				.thenReturn(paginaDeDados);

		Mockito.when(produtoRepositorio.findById(idProdutoExistente)).thenReturn(Optional.of(produto));
		Mockito.when(produtoRepositorio.getReferenceById(idProdutoExistente)).thenReturn(produto);

		Mockito.when(produtoRepositorio.findById(idProdutoInexistente)).thenReturn(Optional.empty());
		Mockito.when(produtoRepositorio.getReferenceById(idProdutoInexistente))
				.thenThrow(ExcecaoEntidadeNaoEncontrada.class);

		Mockito.when(produtoRepositorio.save(ArgumentMatchers.any())).thenReturn(produto);

		// mockando categorias e embalagens
		Mockito.when(embalagemRepositorio.getReferenceById(idProdutoExistente)).thenReturn(embalagem);
		Mockito.when(embalagemRepositorio.getReferenceById(idProdutoInexistente))
				.thenThrow(ExcecaoEntidadeNaoEncontrada.class);

		Mockito.when(categoriaRepositorio.getReferenceById(idProdutoExistente)).thenReturn(categoria);
		Mockito.when(categoriaRepositorio.getReferenceById(idProdutoInexistente))
				.thenThrow(ExcecaoEntidadeNaoEncontrada.class);

		// mockando repositirios para exclusao de produtos
		Mockito.doNothing().when(produtoRepositorio).deleteById(idProdutoExistente);
		doNothing().when(produtoRepositorio).deleteById(idProdutoExistente);

		Mockito.doThrow(ExcecaoEntidadeNaoEncontrada.class).when(produtoRepositorio).deleteById(idProdutoInexistente);
		doThrow(ExcecaoEntidadeNaoEncontrada.class).when(produtoRepositorio).deleteById(idProdutoExistente);

		Mockito.doThrow(ExcecaoIntegridadeBancoDeDados.class).when(produtoRepositorio).deleteById(idProdutoDependente);
		doThrow(ExcecaoIntegridadeBancoDeDados.class).when(produtoRepositorio).deleteById(idProdutoDependente);

	}

	@Test
	void findAllShouldReturnPageOfProdutos() {

		Pageable listaPaginada = PageRequest.of(0, 24);
		// nao informa id de categoria, nem de embalagem e nem descricao do produto para
		// retornar tudo
		Page<ProdutoDTO> paginaDeProdutos = produtoServico.buscarTodos(0L, 0L, "", listaPaginada);
		Assertions.assertNotNull(paginaDeProdutos);
		Mockito.verify(produtoRepositorio, Mockito.times(1)).buscarProdutosPorEmbalagemECategoria(null, null, "",
				listaPaginada);

	}

	@Test
	void findProdutoByIdShoudReturnProdutoDTOWhenIdExists() {

		produtoDTO = produtoServico.buscarPorId(idProdutoExistente);
		Assertions.assertNotNull(produtoDTO);
		Mockito.verify(produtoRepositorio, Mockito.times(1)).findById(idProdutoExistente);

	}

	@Test
	void findProdutoByIdShouldThrowResourceNotFoundExceptionWhenProductIdDoesNotExist() {
		Assertions.assertThrows(ExcecaoEntidadeNaoEncontrada.class, () -> {
			produtoServico.buscarPorId(idProdutoInexistente);
		});

	}

	@Test
	void insertProdutoShouldAutoIncrementProdutoIdWhenNewProductIsCreated() {

		produtoDTO.setId(null);
		Assertions.assertNull(produtoDTO.getId());

		ProdutoDTO resultadoProdutoDTO = produtoServico.inserir(produtoDTO);
		Assertions.assertNotNull(resultadoProdutoDTO.getId());

	}

	@Test
	void updateProdutoShouldReturnProductDTOWhenIdExists() {

		ProdutoDTO resultadoProdutoDTO = produtoServico.update(idProdutoExistente, produtoDTO);
		Assertions.assertNotNull(resultadoProdutoDTO);
	}

	@Test
	void updateProdutoShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ExcecaoEntidadeNaoEncontrada.class, () -> {
			produtoServico.update(idProdutoInexistente, produtoDTO);
		});
	}

	@Test
	void deleteProdutoShouldDoNothingWhenProdutoIdExists() {
		
		Assertions.assertDoesNotThrow(() -> {
			produtoServico.deleteById(idProdutoExistente);
		});
		Mockito.verify(produtoRepositorio, Mockito.times(1)).deleteById(idProdutoExistente);
		verify(produtoRepositorio).deleteById(idProdutoExistente);;

	}

	@Test
	void deteteShouldThrowsExcecaoEntidadeNaoEncontradaWhenProdutoIdDoesNotExist() {
		Assertions.assertThrows(ExcecaoEntidadeNaoEncontrada.class, () -> {
			produtoServico.buscarPorId(idProdutoInexistente);
		});
	}

	@Test
	void deteleShouldThrowsExcecaoIntegridadeBancoDeDadosWhenProdutoIdDepends() {
		Assertions.assertThrows(ExcecaoIntegridadeBancoDeDados.class, () -> {
			produtoServico.deleteById(idProdutoDependente);
		});
	}

}
