package com.sistemadevendas.feltrokinha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@Column(name = "preco_atual")
	private BigDecimal precoAtual;

	private Boolean ativo;

	@NotBlank
	@Min(0)
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;


	private String unidadeMedida;
	
	
	public Produto() {

	}

	public Produto(Integer id, String nome, BigDecimal precoAtual, Integer quantidadeEstoque, String unidadeMedida) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoAtual = precoAtual;
		this.quantidadeEstoque = quantidadeEstoque;
		this.unidadeMedida = unidadeMedida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoAtual() {
		return precoAtual;
	}

	public void setPrecoAtual(BigDecimal precoAtual) {
		this.precoAtual = precoAtual;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void baixaEstoque(@Positive Integer quantidade){
		final int novaQuantidade = this.getQuantidadeEstoque() - quantidade;

		if (novaQuantidade < 0){
			throw new IllegalArgumentException(
					"Não há disponibilidade no estoque de "
					+quantidade + " itens do produto " + this.getNome() + "."
					+"Temos disponível apenas " + this.quantidadeEstoque + "Itens");
		}
		this.setQuantidadeEstoque(novaQuantidade);
	}

	public void adicionaEstoque(@Min(1) Integer quantidade){
		this.setQuantidadeEstoque(this.getQuantidadeEstoque() + quantidade);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Produto produto = (Produto) o;
		return Objects.equals(id, produto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Produto{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", precoAtual=" + precoAtual +
				", ativo=" + ativo +
				'}';
	}

}
