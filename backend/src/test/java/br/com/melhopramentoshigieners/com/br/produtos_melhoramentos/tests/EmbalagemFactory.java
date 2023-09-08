package br.com.melhopramentoshigieners.com.br.produtos_melhoramentos.tests;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;

public class EmbalagemFactory {
	
	public static Embalagem criarEmbalagem () {
		return new Embalagem(1L, "Caixa com 20.000 folhas");
	}

}
