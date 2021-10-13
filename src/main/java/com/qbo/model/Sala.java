package com.qbo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */

@Getter
@Setter
@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsala;

	private int asientos;

	private String descsala;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="idestado")
	private Estado estado;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asiento> listasiento = new ArrayList<Asiento>();
	
	



}