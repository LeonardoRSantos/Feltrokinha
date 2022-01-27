package com.sistemadevendas.feltrokinha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadevendas.feltrokinha.model.Produto;
import com.sistemadevendas.feltrokinha.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/addProduto")
	private ResponseEntity<String> salvar(@RequestBody @Valid Produto produto) {
		produtoService.create(produto);
		return ResponseEntity.ok("Novo Produto Cadastrado");


	}
	
	@GetMapping("/getAllProdutos")
	public List<Produto> list(){
		return produtoService.findAll();
	}

}
