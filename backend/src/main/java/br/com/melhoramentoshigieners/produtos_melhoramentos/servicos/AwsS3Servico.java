package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.io.File;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AwsS3Servico {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AwsS3Servico.class);
	
	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;
	
	public void uploadFile(String caminhoLocalDoArquivo) {
		try {
			File arquivo = new File(caminhoLocalDoArquivo);
			LOGGER.info("Início do Envio");
			s3client.putObject(new PutObjectRequest(bucketName, "imagem.png", arquivo));
			LOGGER.info("Envio Concluído");
			
		} catch (AmazonServiceException excecao){
			LOGGER.info("Código da exceção de serviço AWS: " + excecao.getErrorCode());
			
		} catch (AmazonClientException excecao) {
			LOGGER.info("Mensagem da exceção de Serviço AWS: " + excecao.getMessage());
			
		}
	}
	

}
