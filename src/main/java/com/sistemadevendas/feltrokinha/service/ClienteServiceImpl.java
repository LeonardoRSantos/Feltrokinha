package com.sistemadevendas.feltrokinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadevendas.feltrokinha.exceptions.ObjectNotFoundException;
import com.sistemadevendas.feltrokinha.model.Cliente;
import com.sistemadevendas.feltrokinha.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Integer id) {

		Optional<Cliente> result = clienteRepository.findById(id);

		return result.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id));
	}

	public String delete(Integer id) {
		
		try {
			clienteRepository.deleteById(id);
			
			String msg = "{msg: 'Excluido com sucesso'}";
			
			return msg;
			
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	@Override
	public Cliente update(Cliente obj, Integer id) {
		Cliente newCliente = findById(id);
		
		newCliente.setNome(obj.getNome());
		newCliente.setEmail(obj.getEmail());
		newCliente.setCpf(obj.getCpf());
		newCliente.setCelular(obj.getCelular());
		
		return clienteRepository.save(newCliente);
		
	}
	
	@Override
	public List<Cliente> filterNome(String nome){
		List<Cliente> obj = clienteRepository.findClientebyNome(nome);
		return obj;
	}
}
