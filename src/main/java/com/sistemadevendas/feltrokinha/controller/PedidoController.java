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

import com.sistemadevendas.feltrokinha.model.Pedido;
import com.sistemadevendas.feltrokinha.service.PedidoService;
import com.sistemadevendas.feltrokinha.service.PedidoServiceImpl;

@RestController
@RequestMapping("/vendas")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping(value = "/create")
	private ResponseEntity<String> salvar(@RequestBody @Valid Pedido pedido) {
		pedidoService.create(pedido);
		return ResponseEntity.ok("Novo Pedido Cadastrado");

	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		return ResponseEntity.ok(pedidoService.findAll());
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Pedido obj = pedidoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Pedido update(@RequestBody @Valid Pedido pedido, @PathVariable Integer id) {
		return pedidoService.update(pedido, id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		String msg = ((PedidoServiceImpl) pedidoService).delete(id);

		return ResponseEntity.ok().body(msg);
	}
	
	@RequestMapping(value = "/*/*", method = RequestMethod.POST)
	public ResponseEntity<List<Pedido>> filterId(@RequestParam(value = "id")Integer id){
		List<Pedido> obj = pedidoService.filterId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
