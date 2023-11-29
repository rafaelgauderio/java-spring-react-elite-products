package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.enumerados.Permissao;
import org.springframework.context.annotation.Bean;
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
import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableResourceServer
public class ServidorDeRecursosConfiguracao extends ResourceServerConfigurerAdapter {

    // todos podem acessar essa rota
    private static final String [] ROTA_PUBLICA = {"/oauth/token"};

    private static final String ROTA_BANCO_H2 = "/console-h2-database/**";

    // rotas liberadas consultar o catálogo
    private static final String [] ROTA_CONSULTAR_CATALOGO = {"/produtos/**","/categorias/**","/embalagens/**","/colaboradores/**","/departamentos/**"};

    // rotas liberadas para CRUD de entidades
    private static final String [] ROTA_CRUD_ENTIDADES = {"/produtos/**","/categorias/**","/embalagens/**"};
    
    // rotas liberadas para CRUD de colaboradores e departamentos
    private static final String [] ROTA_CRUD_COLABORADORES = {"/colaboradores/**","/departamentos/**"};

    // rotas liberadas para CRUD de entidades
    private static final String [] ROTA_ADMINTRADORES = {"/usuarios/**"};

    private static final String [] HOST_LIBERADOS={"https://melhoramentoshigiene.netlify.app","http://localhost:8080","http://localhost:3000","http://localhost:5173"};

    @Autowired
    private JwtTokenStore armazenaTokenJwt;

    @Autowired
    private Environment ambiente;

    @Value("${cors.origins")
    private String origensCors;


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
                .antMatchers(HttpMethod.POST,ROTA_CRUD_COLABORADORES).hasRole(String.valueOf(Permissao.ADMIN_SISTEMA))
                .antMatchers(HttpMethod.PUT,ROTA_CRUD_COLABORADORES).hasRole(String.valueOf(Permissao.ADMIN_SISTEMA))
                .antMatchers(HttpMethod.DELETE,ROTA_CRUD_COLABORADORES).hasRole(String.valueOf(Permissao.ADMIN_SISTEMA))
                .antMatchers(ROTA_ADMINTRADORES).hasRole(String.valueOf(Permissao.ADMIN_SISTEMA));                
    }

    // configuração de CORS
    // Cross-origin resource sharing
    // por padão os framework bloqueiam que o frontend hospeda em diferente host do backend faça requisições ao backend
    // liberar aqui expliçadamente quais endereços podem fazer requisições ao backend 
    @Bean
    public CorsConfigurationSource configuracaoDaFonteDeCors() {

        CorsConfiguration configuracaoDeCors = new CorsConfiguration();

        String [] hostLiberados = origensCors.split(",");
        configuracaoDeCors.setAllowedOriginPatterns(Arrays.asList(HOST_LIBERADOS));
       // configuracaoDeCors.setAllowedOriginPatterns(Arrays.asList(hostLiberados));

        List<String> metodosHttp = new LinkedList<String>();
        metodosHttp.add("GET");
        metodosHttp.add("POST");
        metodosHttp.add("PUT");
        metodosHttp.add("DELETE");
        metodosHttp.add("OPTIONS");
        metodosHttp.add("COPY");
        metodosHttp.add("HEAD");
        metodosHttp.add("LINK");
        metodosHttp.add("UNLINK");
        metodosHttp.add("LOCK");
        metodosHttp.add("UNLOCK");
        metodosHttp.add("VIEW");

        configuracaoDeCors.setAllowedMethods(metodosHttp);
        configuracaoDeCors.setAllowCredentials(true);
        configuracaoDeCors.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource configuracaoDaFonte = new UrlBasedCorsConfigurationSource();
        configuracaoDaFonte.registerCorsConfiguration("/**", configuracaoDeCors);
        return configuracaoDaFonte;
    }
    
    @Bean
    public FilterRegistrationBean<CorsFilter> filtroDeCors() {
        FilterRegistrationBean<CorsFilter> bean
                = new FilterRegistrationBean<>(new CorsFilter(configuracaoDaFonteDeCors()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}