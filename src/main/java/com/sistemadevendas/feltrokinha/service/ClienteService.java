package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import com.sistemadevendas.feltrokinha.model.Cliente;

public interface ClienteService {
	
	public Cliente create(Cliente cliente);
	public List<Cliente> findAll();
	public Cliente findById(Integer id);
	public Cliente update(Cliente obj, Integer id);
	public List<Cliente> filterNome(String nome);
}
