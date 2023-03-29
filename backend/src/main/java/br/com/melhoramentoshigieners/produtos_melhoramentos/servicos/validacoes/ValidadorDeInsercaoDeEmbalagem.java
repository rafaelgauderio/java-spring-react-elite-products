package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes;

import br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes.CamposDeValidacao;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Vector;

public class ValidadorDeInsercaoDeEmbalagem implements ConstraintValidator<EmbalagemValidacaoDeInsercao, EmbalagemDTO> {

    @Autowired
    private EmbalagemRepositorio embalagemRepositorio;

    @Override
    public void initialize(EmbalagemValidacaoDeInsercao constraintAnnotation) {

    }

    @Override
    public boolean isValid(EmbalagemDTO dto, ConstraintValidatorContext contexto) {

        Vector<CamposDeValidacao> vetor = new Vector<CamposDeValidacao>();

        Embalagem embalagem = embalagemRepositorio.findByDescricao(dto.getDescricao());

        if(embalagem != null) {
            vetor.add(new CamposDeValidacao("descricao", "Nome da embalagem já cadastrado no base de dados. Favor informar outro"));
        }

        for (CamposDeValidacao camposDeValicadao : vetor) {
            contexto.disableDefaultConstraintViolation();
            contexto.buildConstraintViolationWithTemplate(
                    camposDeValicadao.getMensagem()).addPropertyNode(camposDeValicadao.getNomeDoCampo()).addConstraintViolation();
        }

        return vetor.isEmpty()==true;
    }
}