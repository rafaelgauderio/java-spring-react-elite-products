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

    @BeforeEach
    void setUp() throws Exception {
        this.idExistente = 1L;
        this.idNaoCadastrada = 100L;
    }

    @Test
    public void deletarPorIdDeveDeletarObjetoSeIdExistir() {
        embalagemRepositorio.deleteById(2L);
        Optional<Embalagem> optionalEmbalagem = embalagemRepositorio.findById(idExistente);

        Assertions.assertFalse(optionalEmbalagem.isEmpty());
    }

    @Test
    public void deleterPorIdDeveEstourourExcecaoSeIdNaoCadastradaNoDataBase () {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            embalagemRepositorio.deleteById(idNaoCadastrada);
        });
    }
}
