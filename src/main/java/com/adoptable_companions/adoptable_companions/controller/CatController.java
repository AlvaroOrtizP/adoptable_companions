package com.adoptable_companions.adoptable_companions.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptable_companions.adoptable_companions.entity.CatEntity;
import com.adoptable_companions.adoptable_companions.service.CatService;

@RestController
@RequestMapping("/gato")
public class CatController {
	
	@Autowired
	CatService catService;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllCats() {
		// Caso de error
		List<CatEntity> response = new ArrayList<>();
		response = catService.getAllCats();
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

	@GetMapping("/raza/{race}")
	public ResponseEntity<?> getCatsByRace(@PathVariable Long id) {
		// Caso de error
		Map<String, Object> response = new HashMap<>();

		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
	
	@GetMapping("/elegir/{id}")
	public ResponseEntity<?> adoptarGato(@PathVariable Long id) {
		// Caso de error
		Map<String, Object> response = new HashMap<>();

		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
