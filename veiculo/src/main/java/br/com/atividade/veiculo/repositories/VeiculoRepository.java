package br.com.atividade.veiculo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atividade.veiculo.entities.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Integer>{
	
}