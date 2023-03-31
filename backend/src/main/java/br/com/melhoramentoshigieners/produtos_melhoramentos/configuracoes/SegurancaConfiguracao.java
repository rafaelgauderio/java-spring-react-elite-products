package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

//@Configuration
public class SegurancaConfiguracao {

    @Value("${jwt.secret}")
    private String senhaJwt;


}