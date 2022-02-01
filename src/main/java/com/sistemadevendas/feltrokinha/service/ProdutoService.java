package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import com.sistemadevendas.feltrokinha.model.Produto;

public interface ProdutoService {
	
	public Produto create(Produto produto);
	public List<Produto> findAll();
	public Produto findById(Integer id);
	public Produto atualizaPropriedadeAtivo(Integer id, Boolean ativo);
	public Produto update(Integer id, Produto produto);
	public List<Produto> filterNome(String nome);
	
	

}
