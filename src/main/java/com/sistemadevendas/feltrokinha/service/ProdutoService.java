package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import com.sistemadevendas.feltrokinha.model.Produto;

public interface ProdutoService {
	
	public Produto create(Produto produto);
	public List<Produto> findAll();
	public Produto findById(Integer id);
	

}
