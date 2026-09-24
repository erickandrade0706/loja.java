package br.com.loja.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Categorias", uniqueConstraints = {
        @UniqueConstraint(name = "uk_categoria_nome", columnNames = "nome")
})
public class Categoria {

    // Identificador único da categoria no banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Nome da categoria; precisa ser único para evitar duplicidade
    @Column(nullable = false, length = 80)
    private String nome;

    // Descrição da categoria para explicar o seu uso ou contexto
    @Column(nullable = false, length = 255)
    private String descricao;

    // Lista de produtos vinculados a esta categoria
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos = new ArrayList<>();

    // Construtor padrão necessário para o JPA
    public Categoria() {}

    // Construtor utilizado para criar uma categoria com nome e descrição
    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e setters para acesso aos dados da entidade
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public long getId() { return id; }
    public List<Produto> getProdutos() { return produtos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setId(long id) { this.id = id; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
