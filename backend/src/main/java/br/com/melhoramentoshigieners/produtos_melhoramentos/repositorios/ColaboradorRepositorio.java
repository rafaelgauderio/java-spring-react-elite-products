package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Colaborador;

@Repository
public interface ColaboradorRepositorio extends JpaRepository <Colaborador, Long>{
	
}
