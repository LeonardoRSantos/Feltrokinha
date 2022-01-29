package com.sistemadevendas.feltrokinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadevendas.feltrokinha.exceptions.ObjectNotFoundException;
import com.sistemadevendas.feltrokinha.model.Produto;
import com.sistemadevendas.feltrokinha.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto create(Produto produto) {
		
		produto.setNome(produto.getNome());
		
		
		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> findAll() {

		return produtoRepository.findAll();
	}
	
	@Override
	public Produto findById(Integer id) {
		
		Optional<Produto> result = produtoRepository.findById(id);
		
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id));
		
	}

}
