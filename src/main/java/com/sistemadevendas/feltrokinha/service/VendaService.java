package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import com.sistemadevendas.feltrokinha.model.Venda;

public interface VendaService {
	
	public Venda create(Venda venda);
	public List<Venda> findAll();

}
