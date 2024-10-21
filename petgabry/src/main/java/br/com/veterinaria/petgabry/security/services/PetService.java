package br.com.veterinaria.petgabry.security.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.dto.FinalizaCadastroDTO;
import br.com.veterinaria.petgabry.security.dto.PetDTO;
import br.com.veterinaria.petgabry.security.dto.PetInfoDTO;
import br.com.veterinaria.petgabry.security.dto.PetResponseDTO;
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
		
		Clinica clinica = clinicaRepository.buscarClinica(pet.getNomeClinica());
		if (clinica == null) {
		    throw new IllegalArgumentException("Clínica com nome " + pet.getNomeClinica() + " não encontrada.");
		}
		newPet.setClinica(clinica);

		User user = userRepository.buscarUser(pet.getNomeDono());
		if (user == null) {
		    throw new IllegalArgumentException("Usuário com nome " + pet.getNomeDono() + " não encontrado.");
		}
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
	
	public PetResponseDTO finalizarCadastro(FinalizaCadastroDTO request) {
	    User user = userRepository.buscarUser(request.getNomeDono());
	    if (user == null) {
	        throw new IllegalArgumentException("Usuário com nome " + request.getNomeDono() + " não encontrado.");
	    }

	    Pet pet = petRepository.findByNomePetAndUser(request.getNomePet(), user)
	        .orElseThrow(() -> new IllegalArgumentException("Pet com nome " + request.getNomePet() + " não encontrado para o dono " + request.getNomeDono()));
	    pet.setTipo(request.getTipo());
	    pet.setServicoAtual(request.getServicoAtual());
	    petRepository.save(pet);

	    return new PetResponseDTO(
	        pet.getId(),
	        pet.getNomePet(),
	        pet.getTipo(),
	        pet.getServicoAtual(),
	        pet.getUser().getUsername(),
	        pet.getClinica().getNome()
	    );
	}

	
	public boolean atualizarPet(int id, PetDTO petDTO) {
	    Optional<Pet> optionalPet = petRepository.findById(id);
	    if (optionalPet.isPresent()) {
	        Pet pet = optionalPet.get();
	        pet.setNomePet(petDTO.getNomePet());

	        Clinica clinica = clinicaRepository.buscarClinica(petDTO.getNomeClinica());
	        if (clinica == null) {
	            throw new IllegalArgumentException("Clínica com nome " + petDTO.getNomeClinica() + " não encontrada.");
	        }
	        pet.setClinica(clinica);

	        User user = userRepository.buscarUser(petDTO.getNomeDono());
	        if (user == null) {
	            throw new IllegalArgumentException("Usuário com nome " + petDTO.getNomeDono() + " não encontrado.");
	        }
	        pet.setUser(user);

	        petRepository.save(pet);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public List<PetInfoDTO> listarPetsComInformacoes() {
	    List<Pet> pets = petRepository.findAll();
	    return pets.stream()
	        .map(pet -> new PetInfoDTO(
	            pet.getNomePet(),
	            pet.getServicoAtual(),
	            pet.getTipo()
	        ))
	        .collect(Collectors.toList());
	}


}
