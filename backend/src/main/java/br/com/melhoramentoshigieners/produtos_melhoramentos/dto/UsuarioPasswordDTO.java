package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

// Essa dto vai ter todos os dados do usuario e dto e também a senha.
// vai ser usada apenas para inserir um usuário com uma senha criptografada (encode)
public class UsuarioPasswordDTO extends UsuarioDTO{

    private static final long serialVersionUID =1L;

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
