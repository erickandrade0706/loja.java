package br.com.loja.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Produtos")
public class Produto {

    // Identificador único do produto no banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Descrição detalhada do produto; campo obrigatório
    @Column(nullable = false, length = 255)
    private String descricao;

    // Quantidade disponível em estoque
    @Column(nullable = false)
    private Integer quantidade;

    // Nome do produto exibido ao usuário
    @Column(nullable = false, length = 100)
    private String nome;

    // Valor do produto com precisão monetária de 2 casas decimais
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    // Cada produto pertence a uma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Construtor padrão exigido pelo JPA
    public Produto() {}

    // Construtor auxiliar para instanciar um produto com os dados principais
    public Produto(Long id, String nome, BigDecimal preco, Integer quantidade, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    // Getters e setters para acesso aos atributos da entidade
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}