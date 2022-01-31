package com.sistemadevendas.feltrokinha.model;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	@Positive
	private Integer quantidade = 1;

	@DecimalMin(value = "0.01")
	private BigDecimal valor;

	public Produto getProduto() {
		return id.getProduto();
	}

	@JsonIgnore
	public Pedido gePedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	@PrePersist
	private void prePersist() {
		this.valor = id.getProduto().getPrecoAtual();
	}

	@Transient
	@JsonIgnore
	public BigDecimal getSubTotal() {
		return valor.multiply(new BigDecimal(quantidade));
	}

	public void baixaEstoque(Integer quantidade) {
		this.getProduto().baixaEstoque(quantidade);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ItemPedido))
			return false;
		ItemPedido that = (ItemPedido) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
