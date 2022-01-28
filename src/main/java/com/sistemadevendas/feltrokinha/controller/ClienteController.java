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

import com.sistemadevendas.feltrokinha.model.Cliente;
import com.sistemadevendas.feltrokinha.service.ClienteService;
import com.sistemadevendas.feltrokinha.service.ClienteServiceImpl;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping(value = "/create")
	private ResponseEntity<String> salvar(@RequestBody @Valid Cliente cliente) {
		clienteService.create(cliente);
		return ResponseEntity.ok("Novo Cliente Cadastrado");

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(clienteService.findAll());
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		String msg = ((ClienteServiceImpl) clienteService).delete(id);

		return ResponseEntity.ok().body(msg);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Cliente update(@RequestBody @Valid Cliente cliente, @PathVariable Integer id) {
		return clienteService.update(cliente, id);
	}
	
	@RequestMapping(value = "/*/*", method = RequestMethod.POST)
	public ResponseEntity<List<Cliente>> filterNome(@RequestParam(value = "nome")String nome){
		List<Cliente> obj = clienteService.filterNome(nome);
		
		return ResponseEntity.ok().body(obj);
	}

}
