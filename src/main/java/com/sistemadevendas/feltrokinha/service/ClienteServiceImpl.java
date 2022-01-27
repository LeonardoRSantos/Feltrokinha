package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadevendas.feltrokinha.model.Cliente;
import com.sistemadevendas.feltrokinha.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getAllClientes() {
		
		return clienteRepository.findAll();
	}

}
