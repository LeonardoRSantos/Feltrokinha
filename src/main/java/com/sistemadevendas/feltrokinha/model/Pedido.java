package com.sistemadevendas.feltrokinha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@Column(name = "instante_criacao")
	private LocalDateTime instanteCriacao;

	@Column(columnDefinition = "text")
	private String observacoes;

	@NotNull
	@Column(name = "valor_frete")
	@DecimalMin(value = "0.00")
	private BigDecimal valorFrete;
	
	 @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Pagamento pagamento;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@Embedded
	private EnderecoEntrega enderecoEntrega;

	@PrePersist
	private void prePersist() {
		this.instanteCriacao = LocalDateTime.now();
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public void setInstanteCriacao(LocalDateTime instanteCriacao) {
		this.instanteCriacao = instanteCriacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}
	
	public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnderecoEntrega getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Pedido))
			return false;
		Pedido pedido = (Pedido) o;
		return Objects.equals(getId(), pedido.getId());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Pedido{" + "id=" + id + ", instanteCriacao=" + instanteCriacao + ", observacoes='" + observacoes + '\''
				+ ", valorFrete=" + valorFrete + ", cliente=" + cliente + '}';
	}

}
