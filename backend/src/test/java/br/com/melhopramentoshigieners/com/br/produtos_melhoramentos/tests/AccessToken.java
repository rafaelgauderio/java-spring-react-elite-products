package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class AccessToken {

	@Value("${security.oauth2.client.client-id}")
	private String idCliente;

	@Value("${security.oauth2.client.client-secret}")
	private String senhaCliente;

	public String obterTokenDeAcesso (MockMvc mockMvc, String username, String password) throws Exception {
		
		MultiValueMap<String,String> parametros = new LinkedMultiValueMap<String, String>();
		parametros.add("grant_type", password);
		parametros.add("id_Cliente",idCliente );		
		parametros.add("username", username);
		parametros.add("password", password);
		
		ResultActions resultAction = mockMvc
				.perform(post("/oauth/token")
						.params(parametros)
						.with(httpBasic(idCliente, senhaCliente))
						.accept("application/json;charset=UTF-8"))
						.andExpect(status().isOk())
						.andExpect((ResultMatcher) content().contentType("application/json;charset=UTF-8"));
		
		String StringFinal = resultAction.andReturn().getResponse().getContentAsString();
		
		JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
		return jacksonJsonParser.parseMap(StringFinal).get("access_token").toString();		
		
		
	}

}
