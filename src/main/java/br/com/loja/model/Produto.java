package br.com.loja.model;

import java.math.BigDecimal;

public class Produto {
	private Long id;
	private String nome;
	private BigDecimal preco; // Atualizado para BigDecimal

	// Construtores
	public Produto() {}

	public Produto(Long id, String nome, BigDecimal preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	// Getters e Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public BigDecimal getPreco() { return preco; }
	public void setPreco(BigDecimal preco) { this.preco = preco; }
}