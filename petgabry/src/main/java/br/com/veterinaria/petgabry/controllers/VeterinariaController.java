package br.com.veterinaria.petgabry.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {
	@GetMapping
	public String olaMundo() {
		return("Hello world!");
	}
	
}

