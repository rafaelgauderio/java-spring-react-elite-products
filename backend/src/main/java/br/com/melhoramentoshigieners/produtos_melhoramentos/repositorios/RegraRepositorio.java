package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Regra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraRepositorio extends JpaRepository<Regra, Long> {
}
