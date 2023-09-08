package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;

public class CategoriaFactory {
	
	public static Categoria criarCategoria () {
		return new Categoria(1L, "Amaciante");
	}

}
