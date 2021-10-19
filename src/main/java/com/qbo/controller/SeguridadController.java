package com.qbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.exception.ResourceNotFoundException;
import com.qbo.model.security.Usuario;
import com.qbo.model.security.UsuarioResponse;
import com.qbo.security.UtilToken;
import com.qbo.service.SeguridadService;

@RestController
@RequestMapping(path = "api/v1/seguridad")
public class SeguridadController {
	
	@Autowired
	private UtilToken utilToken;
	
	@Autowired 
	private SeguridadService seguridadService;
	
	@PostMapping("")
	public ResponseEntity<UsuarioResponse> autenticacionUsuario(
			@RequestParam("usuario") String usuario, 
			@RequestParam("password") String password)
		throws ResourceNotFoundException
	{
		Usuario objusuario = seguridadService.autenticarUsuario(usuario, password)
				.orElseThrow(()-> new ResourceNotFoundException("Usuario o password incorrecto"));
		if(usuario != null) {
			String token = utilToken.generarToken(usuario, objusuario.getIdusuario());
			UsuarioResponse usuarioResponse = new UsuarioResponse(objusuario.getIdusuario(),
					objusuario.getNomusuario(), token);
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
	}
	

}
