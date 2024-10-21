package br.com.veterinaria.petgabry.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.dto.PetDTO;
import br.com.veterinaria.petgabry.security.entities.Clinica;
import br.com.veterinaria.petgabry.security.entities.Pet;
import br.com.veterinaria.petgabry.security.entities.User;
import br.com.veterinaria.petgabry.security.repositories.ClinicaRepository;
import br.com.veterinaria.petgabry.security.repositories.PetRepository;
import br.com.veterinaria.petgabry.security.repositories.UserRepository;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClinicaRepository clinicaRepository;
	
	public void cadastrarPet(PetDTO pet) {
		Pet newPet = new Pet();
		newPet.setNomePet(pet.getNomePet());
		newPet.setNomeDono(pet.getNomeDono());
		
		Clinica clinica = clinicaRepository.buscarClinica(pet.getNomeClinica());
		newPet.setClinica(clinica);
		
		User user = userRepository.buscarUser(pet.getNomeDono());
		newPet.setUser(user);
		
		petRepository.save(newPet);
	}
	
	public boolean petDelete(int id) {
		if(petRepository.existsById(id)) {
			petRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	public List<Pet> petList() {
		return petRepository.findAll();
	}
}
