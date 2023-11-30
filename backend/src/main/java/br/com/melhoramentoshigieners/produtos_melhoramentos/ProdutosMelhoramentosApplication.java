package br.com.melhoramentoshigieners.produtos_melhoramentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.AwsS3Servico;

@SpringBootApplication
public class ProdutosMelhoramentosApplication implements CommandLineRunner {

	@Autowired
	private AwsS3Servico awsS3Servico;

	public static void main(String[] args) {
		SpringApplication.run(ProdutosMelhoramentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		awsS3Servico.uploadFile("c:\\imagens\\teste.png");
	}

}
