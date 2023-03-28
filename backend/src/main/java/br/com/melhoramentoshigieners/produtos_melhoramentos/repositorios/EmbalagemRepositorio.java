package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;

@Repository
public interface EmbalagemRepositorio extends JpaRepository<Embalagem, Long> {	
    Embalagem findByDescricao(String descricao);
}
