package br.com.veterinaria.petgabry.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.veterinaria.petgabry.security.entities.Role;
import br.com.veterinaria.petgabry.security.enums.RoleEnum;

@Repository("role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);
}
