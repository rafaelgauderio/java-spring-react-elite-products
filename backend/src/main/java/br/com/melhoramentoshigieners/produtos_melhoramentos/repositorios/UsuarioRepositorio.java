package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
