package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes.UsuarioValidacaoDeAtualizacao;
import java.io.Serializable;

@UsuarioValidacaoDeAtualizacao
public class UsuarioUpdateDTO extends UsuarioDTO implements Serializable {

    private static final long serialVersionUID =1L;
}
