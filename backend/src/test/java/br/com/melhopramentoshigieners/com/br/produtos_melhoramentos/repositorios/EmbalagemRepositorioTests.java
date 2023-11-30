package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.repositorios;

import br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests.EmbalagemFactory;
import br.com.melhoramentoshigieners.produtos_melhoramentos.ProdutosMelhoramentosApplication;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

@ContextConfiguration(classes = ProdutosMelhoramentosApplication.class)
@DataJpaTest
public class EmbalagemRepositorioTests {

    @Autowired
    private EmbalagemRepositorio embalagemRepositorio;

    private Long idNaoCadastrada;
    private Long idExistente;
  
    @BeforeEach
    void setUp() throws Exception {
        idExistente = 2L; 
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
    public void deleteEmbalagemShoudlDeteteObjectWhenIdExists() {
        embalagemRepositorio.deleteById(idExistente);
        Optional<Embalagem> optionalEmbalagem = embalagemRepositorio.findById(idExistente);
        Assertions.assertTrue(optionalEmbalagem.isEmpty());
        Assertions.assertFalse(optionalEmbalagem.isPresent());
    }

    // codigo 404 Not found
    @Test
    public void deteteShoudlThrowEmptResultDataEccessExceptionWhenIdDoesNotExists () {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            embalagemRepositorio.deleteById(idNaoCadastrada);
        });
    }
    
    @Test
    public void saveEmbalagemShouldPersistWithAutoIncrementId () {
    	Embalagem embalagem = EmbalagemFactory.criarEmbalagem();
    	embalagem.setId(null);
    	
    	Assertions.assertNull(embalagem.getId()); // null antes de salvar no banco
    	
    	embalagem = embalagemRepositorio.save(embalagem);
    	Assertions.assertNotNull(embalagem.getId()); // agora id da embalagem não é mais nula depois de salvar no banco
    	// coomo é aunto incremente o proximo número de id de embalagem é o número total de embalagens do banco, por foi inserida por último
    	Assertions.assertEquals(embalagemRepositorio.findAll().size(), embalagem.getId()); 
    }      
    
}
