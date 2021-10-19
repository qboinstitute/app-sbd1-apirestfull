package com.qbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbo.model.security.RolUsuario;
import com.qbo.model.security.Usuario;
import com.qbo.repository.RolUsuarioRepository;
import com.qbo.repository.UsuarioRepository;
@Service
public class SeguridadService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;
	
	public Optional<Usuario> autenticarUsuario(String usuario, String password){
		Optional<Usuario> entityUsuario = usuarioRepository.autenticarUsuario(usuario, password);
		if(entityUsuario.isEmpty()) {
			return Optional.empty();
		}
		return entityUsuario;
	}
	
	public String[] listarRolesPorUsuario(Long idusuario) {
		List<RolUsuario> lista = rolUsuarioRepository.listarRolesPorUsuario(idusuario);
		String[] listaRoles = new String[lista.size()];
		for(int i= 0; i < lista.size(); i++) {
			listaRoles[i] = lista.get(i).getNomrol();
		}
		return listaRoles;		
	}

}
