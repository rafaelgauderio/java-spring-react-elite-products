package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Código  padrão para criar uma @annotation personalizada

@Constraint(validatedBy = ValidadorDeInsercaoDeUsuario.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface UsuarioValidacaoDeInsercao {
    String message() default "Erro de Validação";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}