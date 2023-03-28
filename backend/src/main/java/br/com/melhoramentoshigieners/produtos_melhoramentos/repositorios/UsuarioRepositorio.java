package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

        @Query("SELECT objeto FROM Usuario objeto " +
                "WHERE objeto.email = :email")
        Usuario buscarPorEmail(String email);


        //Usuario findByEmail(String email);
}