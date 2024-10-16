package br.com.veterinaria.petgabry.security.entities;

import br.com.veterinaria.petgabry.security.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//É uma entidade que representa um papel ou função de um usuário em um sistema.
@Entity //representa uma entidade
@Table(name = "roles") //indica a entidade como tabela no banco
public class Role {
	@Id //identifica o elemento único na tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //geração automática do id
	private Integer id; 
	
	@Enumerated(EnumType.STRING) 
	@Column(length = 20)
	private RoleEnum name; 
	
	public Role() {
	}

	public Role(RoleEnum name) {
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleEnum getName() {
		return name;
	}

	public void setName(RoleEnum name) {
		this.name = name;
	}
}
