package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import com.sistemadevendas.feltrokinha.model.Pedido;

public interface PedidoService {
	
	public Pedido create(Pedido venda);
	public List<Pedido> findAll();
	public Pedido update(Pedido obj, Integer id);
	public Pedido findById(Integer id);
	public List<Pedido> filterId(Integer id);
	

}
