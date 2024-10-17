package br.com.veterinaria.petgabry.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.repositories.VeterinariaRepository;

@Service
public class VeterinariaService {

	@Autowired
	VeterinariaRepository veterinariaRepository;
}
