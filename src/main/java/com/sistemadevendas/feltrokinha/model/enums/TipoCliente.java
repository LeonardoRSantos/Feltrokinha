package com.sistemadevendas.feltrokinha.model.enums;

public enum TipoCliente {

	FISICA("Pessoa Fisica"),
	JURIDICA("Pessoa Juridica");

	private String tipo;
	
	private TipoCliente(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
