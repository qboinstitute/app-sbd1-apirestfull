package com.qbo.model.security;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RolUsuario {

	@Id
	private Long idrol;
	
	private String nomrol;
	
	
}
