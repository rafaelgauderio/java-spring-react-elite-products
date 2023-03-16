package br.com.melhoramentoshigieners.produtos_melhoramentos.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	// texto com mais de 255 caracteres
	@Column(columnDefinition = "TEXT")
	private String descricaoCompleta;
	private Double preco;
	private Double comprimento;
	private Double largura;
	private Double altura;
	private Double peso;
	private String imgUrl;

	// salvar no banco sem o timezone para poder alterar de acordo com o local que a
	// API for acessada
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCadastro;

	// um produto pode ter várias embalagens. Associação many to many precisa de um
	// terceira tabela para representar
	@ManyToMany
	@JoinTable(name = "tb_produto_embalagem", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "embalagem_id"))
	private Set<Embalagem> embalagens = new HashSet<Embalagem>();
	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<Categoria>();

	public Produto() {

	}

	public Produto(Long id, String descricao, String descricaoCompleta, Double preco, Double comprimento,
			Double largura, Double altura, Double peso, String imgUrl, Instant dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.descricaoCompleta = descricaoCompleta;
		this.preco = preco;
		this.comprimento = comprimento;
		this.largura = largura;
		this.altura = altura;
		this.peso = peso;
		this.imgUrl = imgUrl;
		this.dataCadastro = dataCadastro;
	}

	public Produto(Long id, String descricao, String descricaoCompleta, String imgUrl , Instant dataCadastro) {

		this.id = id;
		this.descricao = descricao;
		this.descricaoCompleta = descricaoCompleta;
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

	/*
	 * sem método set em coleções public void setEmbalagens(Set<Embalagem>
	 * embalagens) { this.embalagens = embalagens; }
	 */
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	/*
	 * sem método set para coleções public void setCategorias(Set<Categoria>
	 * categorias) { this.categorias = categorias; }
	 */

}
