package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.repositorios;

import br.com.melhoramentoshigieners.produtos_melhoramentos.ProdutosMelhoramentosApplication;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@ContextConfiguration(classes = ProdutosMelhoramentosApplication.class)
@DataJpaTest
public class EmbalagemRepositorioTests {

    @Autowired
    private EmbalagemRepositorio embalagemRepositorio;

    private Long idNaoCadastrada;
    private Long idExistente;
    private Long idDependente;

    @BeforeEach
    void setUp() throws Exception {
        idExistente = 2L; // pode deletar, não existe no banco um id com esse valor
        idDependente = 1L;  // já existe no banco um dia com esse código de embalgem      
        idNaoCadastrada = 100L;
    }
    
    @Test
	public void findByIdShouldReturnOptionalNotEmptyWhenIdExists () { 
		Optional<Embalagem> optinal = embalagemRepositorio.findById(idExistente);		
		Assertions.assertFalse(optinal.isEmpty());
		Assertions.assertTrue(optinal.isPresent());
	}
    
    @Test
	public void findByIdShouldReturnOptinalEmptyWhenIdDoesNotExists() {
	
		Optional<Embalagem> optinal = embalagemRepositorio.findById(idNaoCadastrada);		
		Assertions.assertFalse(optinal.isPresent());
		Assertions.assertTrue(optinal.isEmpty());
	}

    @Test
    public void deletarPorIdDeveDeletarObjetoSeIdExistir() {
        embalagemRepositorio.deleteById(idExistente);
        Optional<Embalagem> optionalEmbalagem = embalagemRepositorio.findById(idExistente);
        Assertions.assertTrue(optionalEmbalagem.isEmpty());
        Assertions.assertFalse(optionalEmbalagem.isPresent());
    }

    // codigo 404 Not found
    @Test
    public void deleterPorIdDeveEstourourExcecaoSeIdNaoCadastradaNoDataBase () {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            embalagemRepositorio.deleteById(idNaoCadastrada);
        });
    }
    
    
    
}
