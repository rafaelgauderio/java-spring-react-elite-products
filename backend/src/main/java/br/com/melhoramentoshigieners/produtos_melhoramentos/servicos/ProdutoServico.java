package br.com.melhoramentoshigieners.produtos_melhoramentos.servicos;

import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.CategoriaDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.EmbalagemDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.dto.ProdutoDTO;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.CategoriaRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.EmbalagemRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios.ProdutoRepositorio;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoEntidadeNaoEncontrada;
import br.com.melhoramentoshigieners.produtos_melhoramentos.servicos.excecoes.ExcecaoIntegridadeBancoDeDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    @Autowired
    private CategoriaRepositorio repositorioDeCategorias;

    @Autowired
    private EmbalagemRepositorio repositorioDeEmbalagens;

    @Autowired
    private ProdutoRepositorio repositorioDeProdutos;

    // funcao trim para tirar os espaços em brancos
    @Transactional(readOnly = true)
    public Page<ProdutoDTO> buscarTodos(Long embalagemId, String descricao, Pageable requisicaoPaginada) {
        List<Embalagem> listDeEmbalagens = (embalagemId==0) ? null : Arrays.asList(repositorioDeEmbalagens.getReferenceById(embalagemId));
        Page<Produto> listaPaginadaDeProdutos = repositorioDeProdutos.buscarProdutosPorEmbalagem(listDeEmbalagens, descricao.trim(),requisicaoPaginada);
        return listaPaginadaDeProdutos.map(p -> new ProdutoDTO(p, p.getEmbalagens(), p.getCategorias()));
    }

    @Transactional(readOnly = true)
    public ProdutoDTO buscarPorId(Long id) {
        Optional<Produto> optionalProduto = repositorioDeProdutos.findById(id);
        Produto entidade = optionalProduto.orElseThrow(() -> new ExcecaoEntidadeNaoEncontrada("Produto não foi encontrado com o id de número " + id));
        ProdutoDTO dto = new ProdutoDTO(entidade, entidade.getEmbalagens(), entidade.getCategorias());
        return dto;
    }

    @Transactional(readOnly = false)
    public ProdutoDTO inserir(ProdutoDTO produtoDTO) {
        Produto entidade = new Produto();
        entidade.setDescricao(produtoDTO.getDescricao());
        entidade.setDescricaoCompleta(produtoDTO.getDescricaoCompleta());
        entidade.setPreco(produtoDTO.getPreco());
        entidade.setLargura(produtoDTO.getLargura());
        entidade.setMetragem(produtoDTO.getMetragem());
        entidade.setPeso(produtoDTO.getPeso());
        entidade.setFragrancia(produtoDTO.getFragrancia());
        entidade.setImgUrl(produtoDTO.getImgUrl());
        entidade.setDataCadastro(produtoDTO.getDataCadastro());

        // percorrendo toda a coleção de embalagens e adicionado no entidade Produto
        //entidade.getEmbalagens().clear();
        for (EmbalagemDTO embDTO : produtoDTO.getEmbalagens()) {
            Embalagem embalagem = repositorioDeEmbalagens.getReferenceById(embDTO.getId());
            entidade.getEmbalagens().add(embalagem);
        }

        // percorrendo toda a coleção de categorias e adicionado no entidade Produto
        //entidade.getCategorias().clear();
        for (CategoriaDTO catDTO : produtoDTO.getCategorias()) {
            Categoria categoria = repositorioDeCategorias.getReferenceById(catDTO.getId());
            entidade.getCategorias().add(categoria);
        }

        entidade = repositorioDeProdutos.save(entidade);
        return new ProdutoDTO(entidade, entidade.getEmbalagens(), entidade.getCategorias());
    }

    @Transactional(readOnly = false)
    public ProdutoDTO update(Long id, ProdutoDTO produtoDTO) {

        try {
            Produto entidade = repositorioDeProdutos.getReferenceById(id);
            entidade.setDescricao(produtoDTO.getDescricao());
            entidade.setDescricaoCompleta(produtoDTO.getDescricaoCompleta());
            entidade.setPreco(produtoDTO.getPreco());
            entidade.setLargura(produtoDTO.getLargura());
            entidade.setMetragem(produtoDTO.getMetragem());
            entidade.setPeso(produtoDTO.getPeso());
            entidade.setFragrancia(produtoDTO.getFragrancia());
            entidade.setImgUrl(produtoDTO.getImgUrl());
            entidade.setDataCadastro(produtoDTO.getDataCadastro());

            entidade.getEmbalagens().clear();
            for (EmbalagemDTO embDTO : produtoDTO.getEmbalagens()) {
                Embalagem embalagem = repositorioDeEmbalagens.getReferenceById(embDTO.getId());
                entidade.getEmbalagens().add(embalagem);
            }

            entidade.getCategorias().clear();
            for (CategoriaDTO catDTO : produtoDTO.getCategorias()) {
                Categoria categoria = repositorioDeCategorias.getReferenceById(catDTO.getId());
                entidade.getCategorias().add(categoria);
            }

            entidade = repositorioDeProdutos.save(entidade);
            ProdutoDTO dto = new ProdutoDTO(entidade, entidade.getEmbalagens(), entidade.getCategorias());
            return dto;

        } catch (EntityNotFoundException erro) {
            throw new ExcecaoEntidadeNaoEncontrada("Não foi encontrado o produto com id de número " + id);
        }

    }


    public void deleteById(Long id) {
        try {
            repositorioDeProdutos.deleteById(id);
        } catch (EmptyResultDataAccessException erro) {
            throw new ExcecaoEntidadeNaoEncontrada("Produto de id de núemro " + id + " não encontrado");
        } catch (DataIntegrityViolationException erro) {
            throw new ExcecaoIntegridadeBancoDeDados("Não é possível excluir um produto referenciado em outras entidades");
        }
    }

}