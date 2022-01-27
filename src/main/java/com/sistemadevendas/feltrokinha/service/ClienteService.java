package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import com.sistemadevendas.feltrokinha.model.Cliente;

public interface ClienteService {
	
	public Cliente saveCliente(Cliente cliente);
	public List<Cliente> getAllClientes();

}
