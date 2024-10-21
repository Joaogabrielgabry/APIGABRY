package br.com.veterinaria.petgabry.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.repositories.ClinicaRepository;

@Service
public class VeterinariaService {

	@Autowired
	ClinicaRepository veterinariaRepository;
}
