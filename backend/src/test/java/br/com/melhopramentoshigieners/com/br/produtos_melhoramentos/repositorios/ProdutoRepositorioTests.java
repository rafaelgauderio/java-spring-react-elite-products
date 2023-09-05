package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.repositorios;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;

import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.ProdutoFactory;
import br.com.melhoramentoshigieners.produtos_melhoramentos.ProdutosMelhoramentosApplication;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ProdutoRepositorio;

@ContextConfiguration(classes = ProdutosMelhoramentosApplication.class)
@DataJpaTest
public class ProdutoRepositorioTests {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    private Long idNaoExistente;
    private Long idExistente;
    private int numeroDeProdutos;
  
    @BeforeEach
    void setUp() throws Exception {
        idExistente = 1L; 
        idNaoExistente = 200L;
        numeroDeProdutos = produtoRepositorio.findAll().size();
    }
    
    @Test
	public void findByIdShouldReturnOptionalNotEmptyWhenIdExists () { 
		Optional<Produto> optinal = produtoRepositorio.findById(idExistente);		
		Assertions.assertFalse(optinal.isEmpty());
		Assertions.assertTrue(optinal.isPresent());
	}
    
    @Test
	public void findByIdShouldReturnOptinalEmptyWhenIdDoesNotExists() {
	
		Optional<Produto> optinal = produtoRepositorio.findById(idNaoExistente);		
		Assertions.assertFalse(optinal.isPresent());
		Assertions.assertTrue(optinal.isEmpty());
	}

    @Test
    public void deleteProdutoShoudlDeteteObjectWhenIdExists() {
        produtoRepositorio.deleteById(idExistente);
        Optional<Produto> optional = produtoRepositorio.findById(idExistente);
        Assertions.assertTrue(optional.isEmpty());
        Assertions.assertFalse(optional.isPresent());
    }

    @Test
    public void deteteProdutoShoudlThrowEmptResultDataEccessExceptionWhenIdDoesNotExists () {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
           produtoRepositorio.deleteById(idNaoExistente);
        });
    }
    
    @Test
    public void saveProductShouldPersistWithAutoIncrementId () {
    	Produto produto = ProdutoFactory.criarProduto();
    	produto.setId(null);
    	
    	Assertions.assertNull(produto.getId());    	
    	produto = produtoRepositorio.save(produto);    	
    	
    
    	Assertions.assertNotNull(produto.getId()); 
    	Assertions.assertEquals(numeroDeProdutos + 2 , produto.getId()); 
    	Assertions.assertEquals(produto.getCategorias().size(),1);
    	Assertions.assertEquals(produto.getEmbalagens().size(),1);
    }    
    
    
    @Test
    public void updateProductShouldUpdateDataOfProdutoWhenIdExist () {
    	
    	Produto produto = ProdutoFactory.criarProduto();
    	produto = produtoRepositorio.save(produto);
    	produto = produtoRepositorio.getReferenceById(produto.getId());    	
    	produto.setFragrancia("Pinho");
    	produto.setDescricao("Sabonete Líquido Pinho");    
    	produto = produtoRepositorio.save(produto);     	
    
    	
    	Assertions.assertNotNull(produto.getId());     	 
    	Assertions.assertEquals(produto.getCategorias().size(),1);
    	Assertions.assertEquals(produto.getEmbalagens().size(),1);
    	Assertions.assertEquals(numeroDeProdutos + 1 , produto.getId()); 
    	Assertions.assertEquals("Pinho", produto.getFragrancia());
    	Assertions.assertEquals("Sabonete Líquido Pinho", produto.getDescricao());
    }  
     
    
}
