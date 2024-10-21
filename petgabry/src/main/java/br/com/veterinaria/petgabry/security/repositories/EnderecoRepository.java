package br.com.veterinaria.petgabry.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.veterinaria.petgabry.security.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	Optional<Endereco> findById(Integer id);
}
