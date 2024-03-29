package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.controladores;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.ProdutoFactory;
import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.TokenAcesso;
import br.com.melhoramentoshigieners.produtos_melhoramentos.ProdutosMelhoramentosApplication;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.ProdutoServico;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;

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

	private TokenAcesso tokenAcesso = new TokenAcesso();

	@Autowired
	private ObjectMapper objetoMapper;

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

		username = "rafaeldeluca@gmail.com";
		password = "123456";

		produtoDTO = ProdutoFactory.criarProdutoDTO();
		paginaDeProdutos = new PageImpl<>(List.of(produtoDTO));

		when(produtoServico.buscarTodos(any(), any(), any(), any())).thenReturn(paginaDeProdutos);

		when(produtoServico.buscarPorId(idExistente)).thenReturn(produtoDTO);
		when(produtoServico.buscarPorId(idNaoExistente)).thenThrow(ExcecaoEntidadeNaoEncontrada.class);

		when(produtoServico.inserir(any())).thenReturn(produtoDTO);

		when(produtoServico.update(eq(idExistente), any())).thenReturn(produtoDTO);
		when(produtoServico.update(eq(idNaoExistente), any())).thenThrow(ExcecaoEntidadeNaoEncontrada.class);

		doNothing().when(produtoServico).deleteById(idExistente);
		doThrow(ExcecaoEntidadeNaoEncontrada.class).when(produtoServico).deleteById(idNaoExistente);
		doThrow(ExcecaoIntegridadeBancoDeDados.class).when(produtoServico).deleteById(idDependente);
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

		ResultActions resultActions = mockMvc
				.perform(get("/produtos/{id}", idExistente).accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$.id").exists());
		resultActions.andExpect(jsonPath("$.descricao").exists());
		resultActions.andExpect(jsonPath("$.descricaoCompleta").exists());
		resultActions.andExpect(jsonPath("$.imgUrl").exists());
	}

	@Test
	void buscarPorIdShouldThrowExcecaoEntidadeNaoEncontradaWhenIdDoesNotExists() throws Exception {

		ResultActions resultAction = mockMvc
				.perform(get("/produtos/{id}", idNaoExistente).accept(MediaType.APPLICATION_JSON));

		resultAction.andExpect(status().isNotFound()); // erro codigo htt 404
	}

	@Test
	void inserirShouldReturnProdutoDTOandIsCreatedStatus() throws Exception {

		String tokenAcessoString = tokenAcesso.obterTokenDeAcesso(mockMvc, username, password);
		// String tokenAcessoString = "";

		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc
				.perform(post("/produtos").header("Authorization", "Bearer " + tokenAcessoString).content(jsonBody)
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		// codigo http 201 - criado com sucesso

		resultActions.andExpect(status().isCreated());
		resultActions.andExpect(jsonPath("$.id").exists());
		resultActions.andExpect(jsonPath("$.descricao").exists());
		resultActions.andExpect(jsonPath("$.descricaoCompleta").exists());
		resultActions.andExpect(jsonPath("$.imgUrl").exists());

	}

	@Test
	void insertShouldThrowUnauthorizedWhenUserIsNotLogged() throws Exception {

		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc.perform(post("/produtos", idExistente).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isUnauthorized()); // erro codigo http 401
	}

	@Test
	void updateShouldReturnProductDTOWhenIdExists() throws Exception {

		String stringTokenAcesso = tokenAcesso.obterTokenDeAcesso(mockMvc, username, password);
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc
				.perform(put("/produtos/{id}", idExistente).header("Authorization", "Bearer " + stringTokenAcesso)
						.content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$.id").exists());
		resultActions.andExpect(jsonPath("$.descricao").exists());
		resultActions.andExpect(jsonPath("$.descricaoCompleta").exists());
		resultActions.andExpect(jsonPath("$.imgUrl").exists());
	}

	@Test
	void updateShouldThrowExcecaoDeEntidadeNaoEncontradaWhenIdDoesNotExist() throws Exception {

		String stringTokenAcesso = tokenAcesso.obterTokenDeAcesso(mockMvc, username, password);
		produtoDTO.setId(idNaoExistente);
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc
				.perform(put("/produtos/{id}", idNaoExistente).header("Authorization", "Bearer " + stringTokenAcesso)
						.content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isNotFound()); // erro codigo http 404

	}

	@Test
	void updateShouldThrowUnauthorizedWhenUserIsNotLogged() throws Exception {

		produtoDTO.setId(idNaoExistente);
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc.perform(put("/produtos/{id}", idNaoExistente).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isUnauthorized()); // erro codigo http 401
	}

	@Test
	void deleteByIdShoudDoNothingAndReturnNoContentWhenIdExists() throws Exception {

		String stringTokenAcesso = tokenAcesso.obterTokenDeAcesso(mockMvc, username, password);
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc.perform(delete("/produtos/{id}", idExistente).content(jsonBody)
				.header("Authorization", "Bearer " + stringTokenAcesso).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isNoContent()); // http 204
	}
	
	@Test
	void deleteByIdShouldThrowUnauthorizedWhenUserIsNotLogged () throws Exception {
		
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc.perform(delete("/produtos/{id}", idExistente).content(jsonBody)				
				.accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isUnauthorized()); // http 401
	}
	
	@Test
	void deleteByIdShoudThrowExcecaoEntidadeNaoEncontradaWhenIdDoesNotExist () throws Exception {

		String stringTokenAcesso = tokenAcesso.obterTokenDeAcesso(mockMvc, username, password);
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);

		ResultActions resultActions = mockMvc.perform(delete("/produtos/{id}", idNaoExistente).content(jsonBody)
				.header("Authorization", "Bearer " + stringTokenAcesso).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		resultActions.andExpect(status().isNotFound()); // http 404
	}
	
	@Test
	void deleteByIdShouldThrowExcecaoIntegridadeDeBancoDeDadosWhenIdDepends () throws Exception {
		
		String stringTokenAcesso = tokenAcesso.obterTokenDeAcesso(mockMvc, username, password);
		String jsonBody = objetoMapper.writeValueAsString(produtoDTO);
		
		ResultActions resultActions = mockMvc.perform(delete("/produtos/{id}", idDependente)
				.content(jsonBody)
				.header("Authorization", "Bearer " + stringTokenAcesso)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isBadRequest()); // http 400
		// não é para excluir um produto que já está vinculado a outra entidade.
	}

}
