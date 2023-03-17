package com.adoptable_companions.adoptable_companions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
	@GetMapping("/")
	public String index() {
		return "¡Hola mundo desde Spring Boot!";
	}

	@GetMapping("/saludar")
	public String saludar() {
		return "¡Hola! ¿Cómo estás?";
	}

	@GetMapping("/despedir")
	public String despedir() {
		return "¡Adiós! ¡Que tengas un buen día!";
	}
}
