package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.servicos;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;

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

import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.ProdutoFactory;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ProdutoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;

@ExtendWith(SpringExtension.class)
public class ProdutoServicosTests {
	
	//testes unitários na camada de servico
	@InjectMocks
	private ProdutoServico produtoServico;
	
	@Mock
	private ProdutoRepositorio produtoRepositorio;
	
	@Mock
	private CategoriaRepositorio categoriaRepositorio;
	
	@Mock
	private EmbalagemRepositorio embalagemRepositorio;
	
	private Long idProdutoExistente, idProdutoInexistente;
	private Produto produto;
	private ProdutoDTO produtoDTO;
	private PageImpl<Produto> paginaDeDados;
	
	@
	BeforeEach
	void setUp () throws Exception {
		
		idProdutoExistente = 1L;
		idProdutoInexistente = 100L;
		
		produto = ProdutoFactory.criarProduto();
		produtoDTO = ProdutoFactory.criarProdutoDTO();
		paginaDeDados = new PageImpl<>(List.of(produto));
		
		Mockito.when(produtoRepositorio.findAll((Pageable)ArgumentMatchers.any())).thenReturn(paginaDeDados);
		Mockito.when(produtoRepositorio.buscarProdutosPorEmbalagemECategoria(any(),any(), any(), any())).thenReturn(paginaDeDados);
		
	

	}
	
	@Test
	void findAllShouldReturnPageOfProdutos () {
		
		Pageable listaPaginada = PageRequest.of(0, 24);
		// nao informa id de categoria, nem de embalagem e nem descricao do produto para retornar tudo
		Page<ProdutoDTO> paginaDeProdutos = produtoServico.buscarTodos(0L,0L,"",listaPaginada);
		Assertions.assertNotNull(paginaDeProdutos);
		
}
	
	
	
	

}
