package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.validacoes.UsuarioValidacaoDeInsercao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

// Essa dto vai ter todos os dados do usuario e dto e também a senha.
// vai ser usada apenas para inserir um usuário com uma senha criptografada (encode)
@UsuarioValidacaoDeInsercao
public class UsuarioPasswordDTO extends UsuarioDTO implements Serializable {

    private static final long serialVersionUID =1L;

    @NotBlank(message ="Obrigatório informar uma senha")
    @Size(min = 6, max=18, message ="Campo senha deve ter entre 6 e 18 caracteres")
    private String password;

    public UsuarioPasswordDTO () {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
