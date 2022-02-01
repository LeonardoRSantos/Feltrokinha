package com.sistemadevendas.feltrokinha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadevendas.feltrokinha.model.Produto;
import com.sistemadevendas.feltrokinha.service.ProdutoService;
import com.sistemadevendas.feltrokinha.service.ProdutoServiceImpl;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping(value = "/create")
	private ResponseEntity<String> salvar(@RequestBody @Valid Produto produto) {
		produtoService.create(produto);
		return ResponseEntity.ok("Novo Produto Cadastrado");

	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		return ResponseEntity.ok(produtoService.findAll());
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Produto obj = produtoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Produto update(@RequestBody @Valid Produto produto, @PathVariable Integer id) {
		return produtoService.update(id, produto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		String msg = ((ProdutoServiceImpl) produtoService).delete(id);

		return ResponseEntity.ok().body(msg);
	}
	
	@RequestMapping(value = "/*/*", method = RequestMethod.POST)
	public ResponseEntity<List<Produto>> filterNome(@RequestParam(value = "nome")String nome){
		List<Produto> obj = produtoService.filterNome(nome);
		
		return ResponseEntity.ok().body(obj);
	}

}
