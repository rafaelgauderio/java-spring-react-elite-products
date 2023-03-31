package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes;

import br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes.CamposDeValidacao;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.UsuarioPasswordDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Vector;

public class ValidadorDeInsercaoDeUsuario implements ConstraintValidator<UsuarioValidacaoDeInsercao, UsuarioPasswordDTO> {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void initialize(UsuarioValidacaoDeInsercao constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UsuarioPasswordDTO usuarioPasswordDTO, ConstraintValidatorContext contexto) {

        Vector<CamposDeValidacao> vetorDeCamposDeValidacao = new Vector<CamposDeValidacao>();

        Usuario usuario = usuarioRepositorio.findByEmail(usuarioPasswordDTO.getEmail());

        if(usuario != null) {
            vetorDeCamposDeValidacao.add(new CamposDeValidacao("Email", "Email: " + usuarioPasswordDTO.getEmail() + " já cadastrado na base de dados. Favor informar outro"));
        }

        for (CamposDeValidacao camposDeValicadao : vetorDeCamposDeValidacao) {
            contexto.disableDefaultConstraintViolation();
            contexto.buildConstraintViolationWithTemplate(
                    camposDeValicadao.getMensagem()).addPropertyNode(camposDeValicadao.getNomeDoCampo()).addConstraintViolation();
        }

        // se não dae nenhum erro de validação, o vetor de erros vai retornar nulo
        return vetorDeCamposDeValidacao.isEmpty()==true;
    }
}
