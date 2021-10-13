package com.qbo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.exception.ResourceNotFoundException;
import com.qbo.model.*;
import com.qbo.model.response.MessageResponse;
import com.qbo.service.EstadoService;

@RestController
@RequestMapping(path = "api/v1/estado")
public class EstadoController {
	
	@Autowired 
	private EstadoService service;
	
	
	@GetMapping("")
	public ResponseEntity<List<Estado>> obtenerTodo(){
		List<Estado> estados = new ArrayList<Estado>();
		service.obtenerTodo().forEach(estados::add);
		if(estados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado){
		Estado _newestado = service.guardar(new Estado(estado.getDescestado()));
		return new ResponseEntity<>(_newestado, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable("id") Integer id)
		throws ResourceNotFoundException
	{
		Estado _estado = service.obtenerPorId(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Not found State with id= "+ id));
		return new ResponseEntity<>(_estado, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> actualizarEstado(@PathVariable("id") Integer id, 
			@RequestBody Estado estado)
					throws ResourceNotFoundException
	{
		Estado _estado = service.obtenerPorId(id)
				.orElseThrow(()-> 
				new ResourceNotFoundException("Not found State with id= "+ id));
		_estado.setDescestado(estado.getDescestado());
		return new ResponseEntity<>(service.guardar(_estado), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> eliminarEstado(@PathVariable("id") Integer id)
			throws ResourceNotFoundException
	{
		Estado _estado = service.obtenerPorId(id)
				.orElseThrow(()-> 
				new ResourceNotFoundException("Not found State with id= "+ id));
		return new ResponseEntity<>(service.eliminarPorId(id), HttpStatus.OK);
	}
	
	

}
