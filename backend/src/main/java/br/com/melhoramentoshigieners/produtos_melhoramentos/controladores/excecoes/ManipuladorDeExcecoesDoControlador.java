package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;
import jakarta.servlet.http.HttpServletRequest;


// annotation que possibilta a interceptacao que qualquer exceção disparada pelo controlador 
@ControllerAdvice
public class ManipuladorDeExcecoesDoControlador {
	
	// annotation para informar quem a exceção da classe service que vai ser intercepatada
	@ExceptionHandler(ExcecaoEntidadeNaoEncontrada.class)
	public ResponseEntity<ExcecaoCustomizada> excecaoEntidadeNaoEncontrada(ExcecaoEntidadeNaoEncontrada mensagemErro, HttpServletRequest requisicao) {
		
		HttpStatus codigoHttp = HttpStatus.NOT_FOUND;
		ExcecaoCustomizada excecaoCustomizada = new ExcecaoCustomizada();
		excecaoCustomizada.setNomeDoErro("Recurso não Encontrado");
		excecaoCustomizada.setMenssagemDeErro(mensagemErro.getMessage());
		excecaoCustomizada.setCaminho(requisicao.getRequestURI());
		excecaoCustomizada.setCodigoHttpDoErro(codigoHttp.value()); // CÓDIGO HTTP 404
		excecaoCustomizada.setMomentoDoErro(Instant.now());
		
		return ResponseEntity.status(codigoHttp).body(excecaoCustomizada);		
	}
	
	@ExceptionHandler(ExcecaoIntegridadeBancoDeDados.class)
	public ResponseEntity<ExcecaoCustomizada> excecaoDeBancoDeDados (ExcecaoIntegridadeBancoDeDados mensagemErro, HttpServletRequest requisicao) {
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		ExcecaoCustomizada excecaoCustomizada = new ExcecaoCustomizada();
		excecaoCustomizada.setNomeDoErro("Exceção de banco de dados");
		excecaoCustomizada.setMenssagemDeErro(mensagemErro.getMessage());
		excecaoCustomizada.setCaminho(requisicao.getRequestURI());
		// não pode excluir um entidade que relaciona com outra entidade. vai dar erro de violação de integridade de database
		excecaoCustomizada.setCodigoHttpDoErro(codigoHttp.value()); // CÓDIGO HTTP 400
		excecaoCustomizada.setMomentoDoErro(Instant.now());
		
		return ResponseEntity.status(codigoHttp).body(excecaoCustomizada);		
	}

}
