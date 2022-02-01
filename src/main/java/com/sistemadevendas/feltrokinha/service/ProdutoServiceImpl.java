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
	
	public String delete(Integer id) {

		try {
			produtoRepository.deleteById(id);

			String msg = "{msg: 'Excluido com sucesso'}";

			return msg;

		} catch (Exception e) {
			return e.toString();
		}
	}

	@Override
	public Produto atualizaPropriedadeAtivo(Integer id, Boolean ativo) {
		Produto produto = this.findById(id);
		produto.setAtivo(ativo);
		return produto;
	}

	@Override
	public Produto update(Integer id, Produto produto) {
		Produto newProduto = findById(id);
		
		newProduto.setNome(produto.getNome());
		newProduto.setPrecoAtual(produto.getPrecoAtual());
		newProduto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
		newProduto.setUnidadeMedida(produto.getUnidadeMedida());
		newProduto.setAtivo(produto.getAtivo());
		
		return produtoRepository.save(newProduto);
	}
	
	@Override
	public List<Produto> filterNome(String nome){
		List<Produto> obj = produtoRepository.findProdutoNome(nome);
		return obj;
	}

}
