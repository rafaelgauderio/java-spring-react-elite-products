package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    Categoria findByDescricao(String descricao);

}
