package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ServidorDeRecursosConfiguracao extends ResourceServerConfigurerAdapter {

    // todos podem acessar essa rota
    private static final String [] ROTA_PUBLICA = {"/oauth/token"};

    // rotas liberadas consyltar o catálogo
    private static final String [] ROTA_CONSULTAR_CATALOGO = {"/produtos/**"};


    @Autowired
    private JwtTokenStore armazenaTokenJwt;


    public ServidorDeRecursosConfiguracao() {
        super();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer recursos) throws Exception {
        recursos.tokenStore(armazenaTokenJwt);
    }

    @Override
    public void configure(HttpSecurity segurancaHttp) throws Exception {
        segurancaHttp.authorizeRequests()
                .antMatchers(ROTA_PUBLICA).permitAll() // publica a rota para fazer autenticacação
                .antMatchers(HttpMethod.GET,ROTA_CONSULTAR_CATALOGO).permitAll();

    }


}
