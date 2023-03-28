package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDTO implements Serializable {

    // parametro password não vai ser exposto no DTO

    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min=3, max=50, message = "Campo nome do usuário deve ter entre 3 e 50 caracteres")
    @NotBlank(message ="Obrigatório preencher o nome do usuário")
    private String nome;

    @Size(min=3, max=50, message = "Campo sobrenome do usuário deve ter entre 3 e 50 caracteres")
    @NotBlank(message ="Obrigatório preencher o sobrenome do usuário")
    private String sobrenome;

    @Email(message="Informar um email válido")
    private String email;
    private Set<RegraDTO> regras = new HashSet<RegraDTO>();

    public UsuarioDTO () {

    }

    public UsuarioDTO(Long id, String nome, String sobrenome, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public UsuarioDTO(Usuario entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.sobrenome = entidade.getSobrenome();
        this.email = entidade.getEmail();
        entidade.getRegras().forEach(
                regra -> this.regras.add(new RegraDTO(regra))
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RegraDTO> getRegras() {
        return regras;
    }

    /* Sem método set para coleções
    public void setRegras(Set<RegraDTO> regras) {
        this.regras = regras;
    }

     */
}