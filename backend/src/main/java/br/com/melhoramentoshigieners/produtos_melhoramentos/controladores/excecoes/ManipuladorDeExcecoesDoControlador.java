package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes;

import java.time.Instant;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoUsuarioNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;

import javax.servlet.http.HttpServletRequest;

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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExcecaoDeValidacao> excecaoDeValidacao (MethodArgumentNotValidException mensagemErro, HttpServletRequest requisicao) {

		HttpStatus codigoHttp = HttpStatus.UNPROCESSABLE_ENTITY; //codigo http 422 - sintaxe correta, mas não foi possível processar a requisição.
		ExcecaoDeValidacao excecaoDeDeValidacao = new ExcecaoDeValidacao();
		excecaoDeDeValidacao.setNomeDoErro("Exceção de validação. Verificar se todos os parâmetros informados estão corretos.");
		excecaoDeDeValidacao.setMenssagemDeErro(mensagemErro.getMessage());
		excecaoDeDeValidacao.setCaminho(requisicao.getRequestURI());
		excecaoDeDeValidacao.setCodigoHttpDoErro(codigoHttp.value());
		excecaoDeDeValidacao.setMomentoDoErro(Instant.now());

		// adicionando do nome do campo e a mensagem de erro a um vetor de erros
		for(FieldError campo : mensagemErro.getBindingResult().getFieldErrors()) {
			excecaoDeDeValidacao.adicionarErro(campo.getField(), campo.getDefaultMessage());
		}

		return ResponseEntity.status(codigoHttp).body(excecaoDeDeValidacao);
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

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ExcecaoCustomizada> excecaoDeUsurioNaoEncontrado (UsernameNotFoundException mensagemErro, HttpServletRequest requisicao) {

		HttpStatus codigoHttp = HttpStatus.NOT_FOUND;
		ExcecaoCustomizada excecaoCustomizada = new ExcecaoCustomizada();
		excecaoCustomizada.setNomeDoErro("Exceção de Usuário Não encontrado");
		excecaoCustomizada.setMenssagemDeErro(mensagemErro.getMessage());
		excecaoCustomizada.setCaminho(requisicao.getRequestURI());
		excecaoCustomizada.setCodigoHttpDoErro(codigoHttp.value());
		excecaoCustomizada.setMomentoDoErro(Instant.now());

		return ResponseEntity.status(codigoHttp).body(excecaoCustomizada);
	}
}