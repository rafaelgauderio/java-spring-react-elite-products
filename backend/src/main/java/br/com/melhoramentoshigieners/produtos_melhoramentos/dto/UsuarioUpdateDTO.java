package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes.UsuarioValidacaoDeAtualizacao;

@UsuarioValidacaoDeAtualizacao
public class UsuarioUpdateDTO extends UsuarioDTO implements Serializable {

    private static final long serialVersionUID =1L;
   

    @NotBlank(message ="Obrigatório informar uma senha")
    @Size(min = 6, max=18, message ="Campo senha deve ter entre 6 e 18 caracteres")
    private String password;

    public UsuarioUpdateDTO () {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

