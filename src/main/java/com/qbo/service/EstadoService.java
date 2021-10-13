package com.qbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.*;
import com.qbo.model.response.MessageResponse;
import com.qbo.repository.EstadoRepository;

@Service
public class EstadoService implements BaseService<Estado> {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> obtenerTodo() {
		return estadoRepository.findAll();
	}

	@Override
	public Optional<Estado> obtenerPorId(Integer id) {
		Optional<Estado> entityEstado = estadoRepository.findById(id);
		if(entityEstado.isEmpty()) {
			return Optional.empty();
		}
		return entityEstado;
	}

	@Override
	public Estado guardar(Estado entity) {
		return estadoRepository.save(entity);
	}

	@Override
	public MessageResponse eliminarPorId(Integer id) {
		MessageResponse respuesta = new MessageResponse();
		estadoRepository.deleteById(id);
		respuesta.setMenssage("Elemento eliminado correctamente");
		return respuesta;
	}

}
