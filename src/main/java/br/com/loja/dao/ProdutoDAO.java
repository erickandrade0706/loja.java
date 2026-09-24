package br.com.loja.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import br.com.loja.model.Produto;
import java.util.List;

// o jpa repository é uma interface que estende a interface JpaRepository do Spring Data JPA. Ele fornece métodos para realizar operações CRUD (Create, Read, Update, Delete) em entidades do banco de dados. No caso do ProdutoRepository, ele é usado para gerenciar a entidade Produto.
@Repository
public class ProdutoDAO { // Nome corrigido para ProdutoDAO

    private final JdbcTemplate jdbcTemplate;

    // Construtor atualizado com o nome correto da classe
    public ProdutoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeia a linha do ResultSet do banco para o objeto Produto do Java
    private final RowMapper<Produto> rowMapper = (rs, rowNum) -> {
        Produto produto = new Produto();
        produto.setId(rs.getLong("id"));
        produto.setNome(rs.getString("nome"));
        produto.setPreco(rs.getBigDecimal("preco")); // Compatível com o BigDecimal do seu professor
        return produto;
    };

    // CREATE (Inserir)
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
        jdbcTemplate.update(sql, produto.getNome(), produto.getPreco());
    }

    // READ (Listar todos)
    public List<Produto> listarTodos() {
        String sql = "SELECT id, nome, preco FROM produto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Produto produto = new Produto();
            produto.setId(rs.getLong("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            return produto;
        });
    }

    // READ (Buscar por ID)
    public Produto buscarPorId(Long id) {
        String sql = "SELECT id, nome, preco FROM produto WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // UPDATE (Atualizar)
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
        jdbcTemplate.update(sql, produto.getNome(), produto.getPreco(), produto.getId());
    }

    // DELETE (Deletar)
    public void deletar(Long id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}
