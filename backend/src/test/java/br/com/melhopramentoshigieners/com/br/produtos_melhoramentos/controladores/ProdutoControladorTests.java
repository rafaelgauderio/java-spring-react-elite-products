package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.controladores;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.ProdutoFactory;
import br.com.melhoramentoshigieners.produtos_melhoramentos.ProdutosMelhoramentosApplication;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;

//@WebMvcTest(ProdutoControlador.class)
@ContextConfiguration(classes = ProdutosMelhoramentosApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProdutoControladorTests {

	@MockBean
	private ProdutoServico produtoServico;

	@Autowired
	private MockMvc mockMvc;

	// não é possivel instanciar um entidade na classe controler
	// se comunica com a classe de serviço via DTO
	private ProdutoDTO produtoDTO;
	private PageImpl<ProdutoDTO> paginaDeProdutos;
	private Long idExistente, idNaoExistente, idDependente;
	private String username;
	private String password;

	@BeforeEach
	void setUp() throws Exception {

		idExistente = 1L;
		idDependente = 3L;
		idNaoExistente = 100L;

		produtoDTO = ProdutoFactory.criarProdutoDTO();
		paginaDeProdutos = new PageImpl<>(List.of(produtoDTO));

		when(produtoServico.buscarTodos(any(), any(), any(), any())).thenReturn(paginaDeProdutos);

		when(produtoServico.buscarPorId(idExistente)).thenReturn(produtoDTO);
		when(produtoServico.buscarPorId(idNaoExistente)).thenThrow(ExcecaoEntidadeNaoEncontrada.class);

	}

	@Test
	void buscarTodosShouldReturnPaginaDeProdutos() {
		try {
			ResultActions resultAction = mockMvc.perform(get("/produtos").accept(MediaType.APPLICATION_JSON));

			resultAction.andExpect(status().isOk());

		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	@Test
	void buscarPorIdShouldReturnProdutoDTOWhenIdExists() throws Exception {
		
		ResultActions resultAction = mockMvc.perform(get("/produtos/{id}", idExistente)
				.accept(MediaType.APPLICATION_JSON));
		
		resultAction.andExpect(status().isOk());
		resultAction.andExpect(jsonPath("$.id").exists());
		resultAction.andExpect(jsonPath("$.descricao").exists());
		resultAction.andExpect(jsonPath("$.descricaoCompleta").exists());
		resultAction.andExpect(jsonPath("$.imgUrl").exists());

	}
	
	@Test
	void buscarPorIdShouldThrowExcecaoEntidadeNaoEncontradaWhenIdDoesNotExists() throws Exception {
		
		ResultActions resultAction = mockMvc.perform(get("/produtos/{id}", idNaoExistente)
				.accept(MediaType.APPLICATION_JSON));
		
				resultAction.andExpect(status().isNotFound()); // erro codigo htt 404
	}

}
