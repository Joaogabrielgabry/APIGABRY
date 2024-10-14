package br.com.veterinaria.petgabry.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.veterinaria.petgabry.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping
	public String olaMundo() {
		emailService.writerTeste3();
		return("Email enviado com sucesso");
	}
	
}

