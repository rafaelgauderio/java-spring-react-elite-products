package br.com.melhoramentoshigieners.produtos_melhoramentos.repositorios;

import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Embalagem;
import br.com.melhoramentoshigieners.produtos_melhoramentos.entidades.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {

    // se não informar uma id de embalagem ou categoria, retornar todos os produtos
    @Query("SELECT DISTINCT objeto FROM Produto objeto " +
            "INNER JOIN objeto.embalagens embals " +
            "WHERE (:embalagem IS NULL OR :embalagem IN embals)")
    Page<Produto> buscarProdutosPorEmbalagem(Embalagem embalagem, Pageable requisicaoPaginada);

}
