package com.sistemadevendas.feltrokinha.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnderecoEntrega implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "entrega_logradouro")
	private String logradouro;
	
	@Column(name = "entrega_numero")
	private String numero;
	
	@Column(name = "entrega_cep")
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
