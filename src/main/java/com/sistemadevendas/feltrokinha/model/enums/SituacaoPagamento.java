package com.sistemadevendas.feltrokinha.model.enums;

public enum SituacaoPagamento {
	
	ORCAMENTO("Orcamento"),
	APROVADO("Aprovado"),
	CANCELADO("Cancelado");
	
	private String situacao;
	
	private SituacaoPagamento(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}

}
