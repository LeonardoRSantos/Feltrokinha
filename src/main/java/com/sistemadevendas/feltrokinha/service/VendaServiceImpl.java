package com.sistemadevendas.feltrokinha.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadevendas.feltrokinha.model.Venda;
import com.sistemadevendas.feltrokinha.repository.VendaRepository;

@Service
@Transactional
public class VendaServiceImpl implements VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public Venda create(Venda venda) {
		
		return vendaRepository.save(venda);
	}

	@Override
	public List<Venda> findAll() {
		
		return vendaRepository.findAll();
	}
	
	

}
