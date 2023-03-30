package br.com.melhoramentoshigieners.produtos_melhoramentos.componentes;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class PotenciadorDeTokenJwt implements TokenEnhancer {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken tokenDeAcesso, OAuth2Authentication autenticacao) {
        Usuario entidade = new Usuario();
        entidade = usuarioRepositorio.buscarPorEmail(autenticacao.getName());

        Map<String, Object> dadosUsuarioAutenticado = new LinkedHashMap<String, Object>();
        dadosUsuarioAutenticado.put("id_usuario", entidade.getId());
        dadosUsuarioAutenticado.put("nome_usuario", entidade.getNome());
        dadosUsuarioAutenticado.put("sobrenome_usuario", entidade.getSobrenome());

        DefaultOAuth2AccessToken defaultTokenDeAcesso = (DefaultOAuth2AccessToken) tokenDeAcesso;
        defaultTokenDeAcesso.setAdditionalInformation(dadosUsuarioAutenticado);

        // é o mesmo token que está retornado, apenas foi turbinado com  informações do usuario autenticado
        return  tokenDeAcesso;

    }
}
