package br.com.loja.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Produtos")

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String descricao;

	@Column(nullable = false)
	private Integer quantidade;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;// Atualizado para BigDecimal

	// Construtores
	public Produto() {}

	public Produto(Long id, String nome, BigDecimal preco, Integer quantidade,String descricao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}

	// Getters e Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public BigDecimal getPreco() { return preco; }
	public void setPreco(BigDecimal preco) { this.preco = preco; }

	public Integer getQuantidade() {return quantidade;}
	public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}

	public String getDescricao() {return descricao;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
}