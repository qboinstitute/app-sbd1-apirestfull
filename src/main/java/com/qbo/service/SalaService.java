package com.qbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.Sala;
import com.qbo.model.response.MessageResponse;
import com.qbo.repository.SalaRepository;

@Service
public class SalaService implements BaseService<Sala> {

	@Autowired
	private SalaRepository salaRepository;
	
	@Override
	public List<Sala> obtenerTodo() {
		return salaRepository.findAll();
	}

	@Override
	public Optional<Sala> obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sala guardar(Sala entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageResponse eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
