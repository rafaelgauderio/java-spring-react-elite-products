package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ProdutoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio repositorioDeProdutos;

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> buscarTodos(Pageable requisicaoPaginada) {
        Page<Produto> listaPaginadaDeProdutos = repositorioDeProdutos.findAll(requisicaoPaginada);
        return listaPaginadaDeProdutos.map(p-> new ProdutoDTO(p, p.getEmbalagens(),p.getCategorias()));
    }

    @Transactional(readOnly = true)
    public ProdutoDTO buscarPorId(Long id) {
        Optional<Produto> optionalProduto = repositorioDeProdutos.findById(id);
        Produto entidade = optionalProduto.orElseThrow(()-> new ExcecaoEntidadeNaoEncontrada("Produto não foi encontrado com o id de número " + id));
        ProdutoDTO dto = new ProdutoDTO(entidade, entidade.getEmbalagens(),entidade.getCategorias());
        return dto;

    }
}
