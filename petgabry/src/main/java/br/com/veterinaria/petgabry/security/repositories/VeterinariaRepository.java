package br.com.veterinaria.petgabry.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.veterinaria.petgabry.security.entities.Pet;

public interface VeterinariaRepository extends
JpaRepository<Pet,Integer>{

}
