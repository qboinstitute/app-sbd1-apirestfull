package com.qbo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qbo.model.Sala;
import com.qbo.service.SalaService;

@RestController
@RequestMapping(path = "api/v1/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("")
	public ResponseEntity<List<Sala>> obtenerTodo(){
		List<Sala> salas = new  ArrayList<Sala>();
		salaService.obtenerTodo().forEach(salas::add);
		if(salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(salas, HttpStatus.OK);
	}

}
