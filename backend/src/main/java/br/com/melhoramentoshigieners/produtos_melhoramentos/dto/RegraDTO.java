package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Regra;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.enumerados.Permissao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RegraDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message="Obrigatório preencher o nome da regra")
    @Size(min=3, max = 20, message="Campo regra deve ter entre 3 e 20 caracteres")
    private String descricao;

    @NotBlank(message="Obrigatório preencher o tipe de permissão da regra")
    private Permissao permissao;

    public RegraDTO () {

    }

    public RegraDTO(Long id, String descricao, Permissao permissao) {
        this.id = id;
        this.descricao = descricao;
        this.permissao = permissao;
    }

    public RegraDTO(Regra entidade) {
        this.id = entidade.getId();
        this.descricao = entidade.getDescricao();
        this.permissao = entidade.getPermissao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
