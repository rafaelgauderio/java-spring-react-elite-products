package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class AwsS3Servico {

	private static Logger LOGGER = LoggerFactory.getLogger(AwsS3Servico.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;

	public URL uploadFile(MultipartFile arquivo) {
		try {
			String nomeOriginalArquivo = arquivo.getOriginalFilename();
			String extensao = FilenameUtils.getExtension(nomeOriginalArquivo);
			String nomeFinalArquivo = nomeOriginalArquivo + "." + extensao;

			InputStream inputStream = arquivo.getInputStream();
			String contentType = arquivo.getContentType();
			return uploadFile(inputStream, nomeFinalArquivo, contentType);

		} catch (IOException exception) {
			throw new IllegalArgumentException(exception.getMessage());
		}

	}

	private URL uploadFile(InputStream inputStream, String nomeFinalArquivo, String contentType) {

		ObjectMetadata objetoMetadados = new ObjectMetadata();
		objetoMetadados.setContentType(contentType);

		LOGGER.info("Início do upload");
		s3client.putObject(bucketName, nomeFinalArquivo, inputStream, objetoMetadados);
		LOGGER.info("Upload finalizado com sucesso!");

		URL urlResultante = s3client.getUrl(bucketName, nomeFinalArquivo);
		return urlResultante;
	}

}
