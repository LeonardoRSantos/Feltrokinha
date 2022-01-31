package com.sistemadevendas.feltrokinha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistemadevendas.feltrokinha.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("select p from Pedido p where p.id = 1")
	List<Pedido> findPedidoById(Integer id);

}
