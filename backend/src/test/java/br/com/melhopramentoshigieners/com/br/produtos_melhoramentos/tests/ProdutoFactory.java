package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests;

import java.time.Instant;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;

public class ProdutoFactory {

	public static Produto criarProduto() {
		Produto produto = new Produto(1L, "Sabonete Líquido Lavanda", "Sabonete Líquido Lavanda galão de 5 litros",
				null, null, null, null, "Lavanda", "https://melhoramentoshigieners.com.br/imagens/sabonete_lavanda.png",
				Instant.now());
		produto.getEmbalagens().add(new Embalagem(1L, "Galão de 5 Litros"));
		produto.getCategorias().add(new Categoria(1L, "Sabonete Líquido"));
		return produto;
	}
	
	public static ProdutoDTO criarProdutoDTO() {
		Produto produto = criarProduto();			
		return new ProdutoDTO(produto, produto.getEmbalagens(),produto.getCategorias());
	}
}
