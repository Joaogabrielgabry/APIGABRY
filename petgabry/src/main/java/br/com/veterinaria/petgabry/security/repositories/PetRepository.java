package br.com.veterinaria.petgabry.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.veterinaria.petgabry.security.entities.Pet;
import br.com.veterinaria.petgabry.security.entities.User;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer>{

	Optional<Pet> findByNomePetAndUser(String nomePet, User user);
}
