package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SegurancaWebConfiguracao extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder senhaCriptograda;

    @Autowired
    private UserDetailsService servicoDeDetalhesDoUsuario;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/actuator/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder autenticador) throws Exception {
         autenticador.userDetailsService(servicoDeDetalhesDoUsuario).passwordEncoder(senhaCriptograda);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}