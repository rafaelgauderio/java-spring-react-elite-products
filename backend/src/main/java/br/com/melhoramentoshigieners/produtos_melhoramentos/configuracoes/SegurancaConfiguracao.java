package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;


import org.springframework.beans.factory.annotation.Value;


//@Configuration
public class SegurancaConfiguracao {

    @Value("${jwt.secret}")
    private String senhaJwt;


}