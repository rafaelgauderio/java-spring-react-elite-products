package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.SmsDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.SmsServico;


@RestController
@RequestMapping(value ="/sms")
public class SmsControlador {
	
	@Autowired
	private SmsServico smsServico;		
	
	@PostMapping("/enviar")
	public void enviarSms (@Valid @RequestBody SmsDTO smsDTO) {
		smsServico.sendSmsToClient(smsDTO);
	}

}

