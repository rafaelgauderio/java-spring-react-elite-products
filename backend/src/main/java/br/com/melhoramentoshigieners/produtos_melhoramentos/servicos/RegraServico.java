package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.RegraDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Regra;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.RegraRepositorio;

@Service
public class RegraServico  {
  

    @Autowired
    private RegraRepositorio regraRepositorio;
	

    @Transactional(readOnly = true)
    public List<RegraDTO> buscarTodasRegras() {
        List<Regra> listaDeRegras = regraRepositorio.findAll();
        return listaDeRegras.stream().map(regra -> new RegraDTO(regra)).collect(Collectors.toList());
    }
   

   
}