package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes;

import br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes.CamposDeValidacao;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioUpdateDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.Vector;

public class ValidadorDeAtualizacaoDeUsuario implements ConstraintValidator<UsuarioValidacaoDeAtualizacao, UsuarioUpdateDTO> {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private HttpServletRequest requisicoes;

    @Override
    public void initialize(UsuarioValidacaoDeAtualizacao constraintAnnotation) {
    }

    @Override
    public boolean isValid(UsuarioUpdateDTO dto, ConstraintValidatorContext contexto) {
    	
    	@SuppressWarnings("unchecked")
        var variaveisIdentificadoras = (Map<String,String>) requisicoes.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Long idDoUsuarioDaRequesicao = Long.parseLong(variaveisIdentificadoras.get("id"));

        Vector<CamposDeValidacao> vetorDeCamposDeValidacao = new Vector<CamposDeValidacao>();
        Usuario usuario = usuarioRepositorio.findByEmail(dto.getEmail());

        if(usuario != null && idDoUsuarioDaRequesicao!=usuario.getId()) {
            vetorDeCamposDeValidacao.add(new CamposDeValidacao("Email", "Email: " + dto.getEmail() + " já cadastrado no base de dados. Favor informar outro"));
        }

        for (CamposDeValidacao camposDeValicadao : vetorDeCamposDeValidacao) {
            contexto.disableDefaultConstraintViolation();
            contexto.buildConstraintViolationWithTemplate(
                    camposDeValicadao.getMensagem()).addPropertyNode(camposDeValicadao.getNomeDoCampo()).addConstraintViolation();
        }

        return vetorDeCamposDeValidacao.isEmpty()==true;
    }
}