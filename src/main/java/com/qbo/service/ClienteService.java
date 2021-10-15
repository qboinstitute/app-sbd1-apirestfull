package com.qbo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qbo.model.Cliente;
import com.qbo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Optional<Cliente> buscarClientePorDni(String dnicliente){
		Optional<Cliente> entityCliente = clienteRepository.buscarClientePorDNI(dnicliente);
		if(entityCliente.isEmpty()) {
			return Optional.empty();
		}else {
			return entityCliente;
		}
	}
	
	public Page<Cliente> buscarClientePorNombre(String nombrecliente, Pageable pageable){
		return clienteRepository.buscarClientePorNombre(nombrecliente, pageable);
	}
	
	
}
