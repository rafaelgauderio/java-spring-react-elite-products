package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.SmsDTO;

@Service
public class SmsServico {
	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	//@Value("${twilio.phone.to}")
	private String twilioPhoneTo;	
	
	public void sendSmsToClient(SmsDTO smsDTO) {	
		
		//String message =  "Visite o nosso cátalogo em https://melhoramentoshigieners.com.br/catalogo";
		String message = smsDTO.getMensagem();
		String brazilCode = "+55";
		twilioPhoneTo = brazilCode + smsDTO.getTelefone();		

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message finalMessage = Message.creator(to, from, message).create();

		System.out.println(finalMessage.getSid());
	}

}
