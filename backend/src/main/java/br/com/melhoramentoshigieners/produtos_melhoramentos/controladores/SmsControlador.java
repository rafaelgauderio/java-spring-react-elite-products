package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.SmsServico;


@RestController
@RequestMapping(value ="/sms")
public class SmsControlador {
	
	@Autowired
	private SmsServico smsServico;		
	
	@GetMapping("/enviar")
	public void enviarSms () {
		smsServico.sendSmsToClient();
	}

}
