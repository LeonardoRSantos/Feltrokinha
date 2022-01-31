package com.sistemadevendas.feltrokinha.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "pagamento_cartao")
public final class PagamentoCartao extends Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Positive
	@Column(name = "numero_parcelas")
	private Short numeroDeParcelas;

	public Short getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Short numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
