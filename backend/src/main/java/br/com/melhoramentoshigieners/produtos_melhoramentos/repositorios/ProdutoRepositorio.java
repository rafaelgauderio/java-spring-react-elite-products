package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Categoria;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {

    // se não informar uma id de embalagem ou categoria, retornar todos os produtos
    // essa primeira consulta não tras as embalagens e categorias para a memoria, o que acaba resultando em várias consultas ao banco
    @Query("SELECT DISTINCT objeto FROM Produto objeto " +
            "INNER JOIN objeto.embalagens embals " +
            "INNER JOIN objeto.categorias cats " +
            "WHERE (:embalagens IS NULL OR embals IN :embalagens) " +
            "AND (:categorias IS NULL OR cats IN :categorias) " +
            "AND (LOWER(objeto.descricao) LIKE LOWER(CONCAT('%',:descricao,'%')) )"
    )
    Page<Produto> buscarProdutosPorEmbalagem(List<Embalagem> embalagens, List<Categoria> categorias, String descricao, Pageable requisicaoPaginada);

    // consulta para resolver o problema de várias consultas ao banco
    // join fetch só funciona com List e não com Page
    // join fetch faz com que os relacionamentos sejam carregados junto com a entidade.
    // join desabilita o carregamento LAZY, assim não precisa ir tocar várias vezes no database
    @Query("SELECT objeto " +
            "FROM Produto objeto "
            + "JOIN FETCH objeto.embalagens " +
            "JOIN FETCH objeto.categorias "
            + "WHERE objeto IN :produtos ")
    List<Produto> buscarProdutosComEmbalgensECategorias(List<Produto> produtos);
}
