package com.qbo.controller;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.exception.ResourceNotFoundException;
import com.qbo.model.Cliente;
import com.qbo.service.ClienteService;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{dni}")
	public ResponseEntity<Cliente> buscarClientePorDNI(
			@PathVariable("dni") String dnicliente)
		throws ResourceNotFoundException
	{
		Cliente cliente = clienteService.buscarClientePorDni(dnicliente)
				.orElseThrow(() -> new ResourceClosedException("Not found Cliente with DNI "+dnicliente));
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<?> buscarClientePorNombre(
			@RequestParam String nombre, Pageable page){
		Page<Cliente> clientes = clienteService.buscarClientePorNombre(nombre, page);
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	
}
