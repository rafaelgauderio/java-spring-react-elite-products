package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableWebSecurity
public class SegurancaWebConfiguracao  {

    @Value("${jwt.secret}")
    private String senhaJwt;

    @Bean
    public BCryptPasswordEncoder criptografarSenha () {
        BCryptPasswordEncoder senhaCriptografada = new BCryptPasswordEncoder();
        return senhaCriptografada;
    }

    @Bean
    JwtAccessTokenConverter converterTokenDeAcesso() {
        JwtAccessTokenConverter tokenJwtDeAcessoConvetido = new JwtAccessTokenConverter();
        tokenJwtDeAcessoConvetido.setSigningKey(senhaJwt);
        return tokenJwtDeAcessoConvetido;
    }

    @Bean
    JwtTokenStore tokenStore() {
        return new JwtTokenStore(converterTokenDeAcesso());
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuracaoDeAutenticacao) throws Exception {
        return configuracaoDeAutenticacao.getAuthenticationManager();
    }
}