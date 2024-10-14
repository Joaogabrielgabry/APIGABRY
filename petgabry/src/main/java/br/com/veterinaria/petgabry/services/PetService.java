package br.com.veterinaria.petgabry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;
}
