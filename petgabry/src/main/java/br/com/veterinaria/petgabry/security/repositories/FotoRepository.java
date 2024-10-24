package br.com.veterinaria.petgabry.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.veterinaria.petgabry.security.entities.Foto;



@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	

}
