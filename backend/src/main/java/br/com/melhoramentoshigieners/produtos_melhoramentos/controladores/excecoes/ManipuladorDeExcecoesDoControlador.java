package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import jakarta.servlet.http.HttpServletRequest;


// annotation que possibilta a interceptacao que qualquer exceção disparada pelo controlador 
@ControllerAdvice
public class ManipuladorDeExcecoesDoControlador {
	
	// annotation para informar quem a exceção da classe service que vai ser intercepatada
	@ExceptionHandler(ExcecaoEntidadeNaoEncontrada.class)
	public ResponseEntity<ExcecaoCustomizada> excecaoEntidadeNaoEncontrada(ExcecaoEntidadeNaoEncontrada mensagemErro, HttpServletRequest requisicao) {
		
		ExcecaoCustomizada excecaoCustomizada = new ExcecaoCustomizada();
		excecaoCustomizada.setNomeDoErro("Entidade ou Objeto não Encontrado");
		excecaoCustomizada.setMenssagemDeErro(mensagemErro.getMessage());
		excecaoCustomizada.setCaminho(requisicao.getRequestURI());
		excecaoCustomizada.setStatusDoErro(HttpStatus.NOT_FOUND.value()); // CÓDIGO HTTP 404
		excecaoCustomizada.setMomentoDoErro(Instant.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excecaoCustomizada);		
	}

}
