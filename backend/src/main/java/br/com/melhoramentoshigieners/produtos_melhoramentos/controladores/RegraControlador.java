package br.com.melhoramentoshigieners.produtos_melhoramentos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.RegraDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.RegraServico;

@RestController
@RequestMapping(value ="/regras")
public class RegraControlador {

    @Autowired
    private RegraServico regraServico;   
    
    
    @GetMapping
    public ResponseEntity<List<RegraDTO>> buscarTodasRegras () {
    	List<RegraDTO> listaRegrasDTO = regraServico.buscarTodasRegras();
    	return ResponseEntity.ok().body(listaRegrasDTO);
    }    
 
    
}