package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;


import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.enumerados.Permissao;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ServidorDeRecursosConfiguracao extends ResourceServerConfigurerAdapter {

    // todos podem acessar essa rota
    private static final String [] ROTA_PUBLICA = {"/oauth/token"};

    private static final String ROTA_BANCO_H2 = "/console-h2-database/**";

    // rotas liberadas consultar o catálogo
    private static final String [] ROTA_CONSULTAR_CATALOGO = {"/produtos/**","/categorias/**","/embalagens/**"};

    // rotas liberadas para CRUD de entidades
    private static final String [] ROTA_CRUD_ENTIDADES = {"/produtos/**","/categorias/**","/embalagens/**"};

    // rotas liberadas para CRUD de entidades
    private static final String [] ROTA_ADMINTRADORES = {"/usuarios/**"};


    @Autowired
    private JwtTokenStore armazenaTokenJwt;

    @Autowired
    private Environment ambiente;


    public ServidorDeRecursosConfiguracao() {
        super();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer recursos) throws Exception {
        recursos.tokenStore(armazenaTokenJwt);
    }

    @Override
    public void configure(HttpSecurity segurancaHttp) throws Exception {

        // liberando para acessar a interface do banco de dados em memória h2
        if (Arrays.asList(ambiente.getActiveProfiles()).contains("test")==true) {
            segurancaHttp.headers().frameOptions().disable();
        }

        segurancaHttp.authorizeRequests()
                .antMatchers(ROTA_PUBLICA).permitAll() // publica a rota para fazer autenticacação
                .antMatchers(ROTA_BANCO_H2).permitAll()
                .antMatchers(HttpMethod.GET,ROTA_CONSULTAR_CATALOGO).permitAll()
                .antMatchers(HttpMethod.POST,ROTA_CRUD_ENTIDADES).hasRole(String.valueOf(Permissao.GERENTE_LOJA))
                .antMatchers(HttpMethod.PUT,ROTA_CRUD_ENTIDADES).hasRole(String.valueOf(Permissao.GERENTE_LOJA))
                .antMatchers(HttpMethod.DELETE,ROTA_CRUD_ENTIDADES).hasRole(String.valueOf(Permissao.GERENTE_LOJA))
                .antMatchers(HttpMethod.OPTIONS,ROTA_CRUD_ENTIDADES).hasRole(String.valueOf(Permissao.GERENTE_LOJA))
                .antMatchers(HttpMethod.HEAD,ROTA_CRUD_ENTIDADES).hasRole(String.valueOf(Permissao.GERENTE_LOJA))
                .antMatchers(ROTA_ADMINTRADORES).hasRole(String.valueOf(Permissao.ADMIN_SISTEMA));
    }
}