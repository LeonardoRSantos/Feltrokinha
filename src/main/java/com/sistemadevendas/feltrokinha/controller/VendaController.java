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

import com.sistemadevendas.feltrokinha.model.Venda;
import com.sistemadevendas.feltrokinha.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
	@Autowired
	private VendaService vendaService;
	
	@PostMapping("/addVendas")
	private ResponseEntity<String> salvar(@RequestBody @Valid Venda venda) {
		vendaService.create(venda);
		return ResponseEntity.ok("Venda Realizada Com Sucesso");


	}
	
	@GetMapping
	public List<Venda> list(){
		return vendaService.findAll();
	}
}
