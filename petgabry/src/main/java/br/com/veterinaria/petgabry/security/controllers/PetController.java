package br.com.veterinaria.petgabry.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	@GetMapping
	public String olaMundo() {
		return("Ola mundo!");
	}
}
