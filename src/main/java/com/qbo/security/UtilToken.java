package com.qbo.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.qbo.service.SeguridadService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class UtilToken {
	
	@Autowired
	private SeguridadService seguridadService;
	
	public String generarToken (String usuario, Long idusuario) {
		String CLAVESECRETA = "${security.clave}";
		List<GrantedAuthority> lstautorizacion = AuthorityUtils
				//.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
				.createAuthorityList(seguridadService.listarRolesPorUsuario(idusuario));
		String token = Jwts
				.builder()
				.setId("@qboJWT")
				.setSubject(usuario)
				.claim("authorities", 
						lstautorizacion.stream().map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList())
						)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 300000))
				.signWith(SignatureAlgorithm.HS512, CLAVESECRETA.getBytes())
				.compact();
		
		return "Bearer "+token;
	}

}
