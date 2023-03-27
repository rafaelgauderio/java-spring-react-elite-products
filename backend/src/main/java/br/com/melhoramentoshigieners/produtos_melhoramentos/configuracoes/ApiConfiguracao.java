package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class ApiConfiguracao {

    // método para criptografar a senha
    @Bean
    public BCryptPasswordEncoder criptografarSenha () {
        BCryptPasswordEncoder senhaCriptografada = new BCryptPasswordEncoder();
        return senhaCriptografada;
    }
    // liberar temporariamente todos os endpoints
}