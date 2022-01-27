package com.sistemadevendas.feltrokinha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistemadevendas.feltrokinha.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
	
	@Query("select v from Venda v where v.nomeProduto like %?1%")
	List<Venda> findVendabyNomeProduto(String nomeProduto);

}
