package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class SegurancaConfiguracao {

    @Value("${jwt.secret}")
    private String senhaJwt;


    @Bean
    public BCryptPasswordEncoder criptografarSenha () {
        BCryptPasswordEncoder senhaCriptografada = new BCryptPasswordEncoder();
        return senhaCriptografada;
    }

    @Bean
    public JwtAccessTokenConverter converterTokenDeAcesso() {
        JwtAccessTokenConverter tokenDeAcessoJwtConvertido = new JwtAccessTokenConverter();
        tokenDeAcessoJwtConvertido.setSigningKey(senhaJwt);
        return tokenDeAcessoJwtConvertido;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(converterTokenDeAcesso());
    }

}