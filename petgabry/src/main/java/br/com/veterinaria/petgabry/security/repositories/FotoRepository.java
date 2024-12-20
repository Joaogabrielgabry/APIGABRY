package br.com.veterinaria.petgabry.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.veterinaria.petgabry.security.entities.Foto;



@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	

	@Query(value = "Select * from foto where usuario_id = :idUsuario" , nativeQuery = true)
	public Foto buscarFotoPorIdUsuario(Integer idUsuario);
}
