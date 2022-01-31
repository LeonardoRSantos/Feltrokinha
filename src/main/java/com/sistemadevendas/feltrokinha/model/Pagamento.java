package com.sistemadevendas.feltrokinha.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistemadevendas.feltrokinha.model.enums.SituacaoPagamento;

@Entity

public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao")
	private SituacaoPagamento situacaoPagamento;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Pagamento))
			return false;
		Pagamento pagamento = (Pagamento) o;
		return Objects.equals(getId(), pagamento.getId());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId());
	}
	
	
}
