package br.com.melhoramentoshigieners.produtos_melhoramentos.configuracoes;

import br.com.melhoramentoshigieners.produtos_melhoramentos.componentes.PotenciadorDeTokenJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class ServidorDeAutorizacaoConfiguracao extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private JwtAccessTokenConverter tokenDeAcessoJwtConvertido;

    @Autowired
    private JwtTokenStore tokenstore;

    @Autowired
    private BCryptPasswordEncoder senhaCriptograda;

    @Autowired
    private AuthenticationManager gerenciadoDeAutenticacao;


    @Value("${security.oauth2.client.client-id}")
    private String idCliente;

    @Value("${security.oauth2.client.client-secret}")
    private String senhaCliente;

    @Value("${jwt.duration}")
    private Integer tempoDuracaoJwt;

    @Autowired
    private PotenciadorDeTokenJwt potenciadorDeTokenJwt;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer configuracaoDeSeguranca) throws Exception {

        configuracaoDeSeguranca.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer cliente) throws Exception {

        cliente.inMemory()
                .withClient(idCliente)
                .secret(senhaCriptograda.encode(senhaCliente))
                .scopes("read","write")
                .authorizedGrantTypes("password")
                .accessTokenValiditySeconds(tempoDuracaoJwt) //8 horas
                ;

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // atualizar o token de autorização com as informações adicionais
        TokenEnhancerChain cadeiaDoTokenTurbinado = new TokenEnhancerChain();

        List<TokenEnhancer> dadosDoTokenTurbinado = new ArrayList<TokenEnhancer>();
        dadosDoTokenTurbinado.add(tokenDeAcessoJwtConvertido);
        dadosDoTokenTurbinado.add(potenciadorDeTokenJwt);

        cadeiaDoTokenTurbinado.setTokenEnhancers(dadosDoTokenTurbinado);

        endpoints.authenticationManager(gerenciadoDeAutenticacao)
                .tokenStore(tokenstore)
                .accessTokenConverter(tokenDeAcessoJwtConvertido)
                .tokenEnhancer(cadeiaDoTokenTurbinado);
    }
}