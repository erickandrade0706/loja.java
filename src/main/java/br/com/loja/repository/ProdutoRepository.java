package br.com.loja.repository;

import br.com.loja.model.Produto;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends
        JpaRepository<Produto, Long> {

}
