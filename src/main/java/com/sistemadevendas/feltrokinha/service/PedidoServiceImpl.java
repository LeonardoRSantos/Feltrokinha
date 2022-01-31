package com.sistemadevendas.feltrokinha.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistemadevendas.feltrokinha.exceptions.ObjectNotFoundException;
import com.sistemadevendas.feltrokinha.model.Pedido;
import com.sistemadevendas.feltrokinha.repository.PedidoRepository;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Pedido create(Pedido pedido) {

		return pedidoRepository.save(pedido);
	}

	@Override
	public List<Pedido> findAll() {

		return pedidoRepository.findAll();
	}

	@Override
	public Pedido findById(Integer id) {
		Optional<Pedido> result = pedidoRepository.findById(id);

		return result.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id));
	}

	@Override
	public Pedido update(Pedido obj, Integer id) {
		Pedido newPedido = findById(id);

		newPedido.setInstanteCriacao(obj.getInstanteCriacao());
		newPedido.setObservacoes(obj.getObservacoes());
		newPedido.setValorFrete(obj.getValorFrete());

		return pedidoRepository.save(newPedido);
	}

	public String delete(Integer id) {

		try {
			pedidoRepository.deleteById(id);

			String msg = "{msg: 'Excluido com sucesso'}";

			return msg;

		} catch (Exception e) {
			return e.toString();
		}
	}

	@Override
	public List<Pedido> filterId(Integer id) {
		List<Pedido> obj = pedidoRepository.findPedidoById(id);
		return obj;
	}

}
