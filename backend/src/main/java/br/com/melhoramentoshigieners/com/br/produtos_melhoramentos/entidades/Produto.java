package br.com.melhoramentoshigieners.com.br.produtos_melhoramentos.entidades;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Produto {

	private Long id;
	private String descricao;
	private Double preco;
	private Double comprimento;
	private Double largura;
	private Double altura;
	private Double peso;
	private String imgUrl;
	private Instant dataCadastro;
	// um produto pode ter várias embalagens
	private Set<Embalagem> embalagens = new HashSet<Embalagem>();
	// um produto pode pertencer a várias categorias diferentes private
	private Set<Categoria> categorias = new HashSet<Categoria>();

	private Produto() {
		
	}

	public Produto(Long id, String descricao, Double preco, Double comprimento, Double largura, Double altura,
			Double peso, String imgUrl, Instant dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.comprimento = comprimento;
		this.largura = largura;
		this.altura = altura;
		this.peso = peso;
		this.imgUrl = imgUrl;
		this.dataCadastro = dataCadastro;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
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

	public Set<Embalagem> getEmbalagens() {
		return embalagens;
	}

	/* sem método set em coleções
	public void setEmbalagens(Set<Embalagem> embalagens) {
		this.embalagens = embalagens;
	}
	*/
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	/* sem método set para coleções
	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}
	*/
	
	
	
	
	
	
	



}
