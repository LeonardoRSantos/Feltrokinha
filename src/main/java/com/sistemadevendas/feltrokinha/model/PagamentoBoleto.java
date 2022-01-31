package com.sistemadevendas.feltrokinha.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "pagamento_boleto")
public final class PagamentoBoleto extends Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "data_vencimento")
	private LocalDate datataVencimento;
	
	@PastOrPresent
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;

	public LocalDate getDatataVencimento() {
		return datataVencimento;
	}

	public void setDatataVencimento(LocalDate datataVencimento) {
		this.datataVencimento = datataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

}
