package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes;

import br.com.melhoramentoshigieners.produtos_melhoramentos.controladores.excecoes.CamposDeValidacao;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Vector;

public class ValidadorDeInsercaoDeCategoria implements ConstraintValidator<CategoriaValidacaoDeInsercao, CategoriaDTO> {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public void initialize(CategoriaValidacaoDeInsercao constraintAnnotation) {

    }

    @Override
    public boolean isValid(CategoriaDTO dto, ConstraintValidatorContext contexto) {

        Vector<CamposDeValidacao> vetor = new Vector<CamposDeValidacao>();

        Categoria categoria = categoriaRepositorio.findByDescricao(dto.getDescricao());

        if(categoria != null) {
            vetor.add(new CamposDeValidacao("descricao", "Nome da Categoria já cadastrado no base de dados. Favor informar outro"));
        }

        for (CamposDeValidacao camposDeValicadao : vetor) {
            contexto.disableDefaultConstraintViolation();
            contexto.buildConstraintViolationWithTemplate(
                    camposDeValicadao.getMensagem()).addPropertyNode(camposDeValicadao.getNomeDoCampo()).addConstraintViolation();
        }

        return vetor.isEmpty()==true;
    }
}