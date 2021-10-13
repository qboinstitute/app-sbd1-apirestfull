package com.qbo.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the estado database table.
 * 
 */
@Getter
@Setter
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idestado;
	
	private String descestado;

	

	public Estado(String descestado) {
		super();
		this.descestado = descestado;
	}

	public Estado() {
	}

	



}