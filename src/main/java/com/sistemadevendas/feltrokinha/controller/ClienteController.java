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

import com.sistemadevendas.feltrokinha.model.Cliente;
import com.sistemadevendas.feltrokinha.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/add")
	private ResponseEntity<String> salvar(@RequestBody @Valid Cliente cliente) {
		clienteService.saveCliente(cliente);
		return ResponseEntity.ok("Novo Cliente Cadastrado");


	}
	
	@GetMapping("/getAll")
	public List<Cliente> list(){
		return clienteService.getAllClientes();
	}

}
