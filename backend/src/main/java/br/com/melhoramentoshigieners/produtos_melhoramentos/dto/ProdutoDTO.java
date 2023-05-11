package br.com.melhoramentoshigieners.produtos_melhoramentos.dto;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Column(unique=true)
    @NotBlank(message="Obrigatório preencher o nome do produto")
    @Size(min=5, max = 50, message="Campo produto deve ter entre 5 e 50 caracteres")
    private String descricao;

    @NotBlank(message="Obrigatório preencher a descrição detalhada do produto")
    @Size(min=5, max=500, message="Campo produto deve ter entre 5 e 500 caracteres")    
    private String descricaoCompleta;

    @PositiveOrZero
    private Double preco;

    private Double largura;
    private Integer metragem;
    private Double peso;
    private String fragrancia;

    @NotBlank(message="Obrigatório preencher o link da imagem")
    @Size(min=5, max=100, message="link deve ter entre 5 e 100 caracteres")
    private String imgUrl;

    @PastOrPresent(message="Não é possivel cadastrar um produto com data futura")
    private Instant dataCadastro;
    private Set<EmbalagemDTO> embalagens = new HashSet<>();
    private Set<CategoriaDTO> categorias = new HashSet<CategoriaDTO>();

    public ProdutoDTO () {

    }

    public ProdutoDTO(Long id, String descricao, String descricaoCompleta, Double preco, Double largura, Integer metragem, Double peso, String fragrancia, String imgUrl, Instant dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.descricaoCompleta = descricaoCompleta;
        this.preco = preco;
        this.largura = largura;
        this.metragem = metragem;
        this.peso = peso;
        this.fragrancia = fragrancia;
        this.imgUrl = imgUrl;
        this.dataCadastro = dataCadastro;
    }

    public ProdutoDTO (Produto produto) {
        super();
        id = produto.getId();
        descricao = produto.getDescricao();
        descricaoCompleta = produto.getDescricaoCompleta();
        preco = produto.getPreco();
        largura = produto.getLargura();
        metragem = produto.getMetragem();
        peso = produto.getPeso();
        fragrancia = produto.getFragrancia();
        imgUrl = produto.getImgUrl();
        dataCadastro = produto.getDataCadastro();
    }


    // sobrecarga adicionando uma lista de embalagens e de categorias
    public ProdutoDTO(Produto produto, Set<Embalagem> embalagens, Set<Categoria> categorias) {
        this(produto);
        embalagens.forEach( x -> this.embalagens.add(new EmbalagemDTO(x)));
        categorias.forEach( x -> this.categorias.add(new CategoriaDTO(x)));
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

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Integer getMetragem() {
        return metragem;
    }

    public void setMetragem(Integer metragem) {
        this.metragem = metragem;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public Set<EmbalagemDTO> getEmbalagens() {
        return embalagens;
    }


    public Set<CategoriaDTO> getCategorias() {
        return categorias;
    }

}
