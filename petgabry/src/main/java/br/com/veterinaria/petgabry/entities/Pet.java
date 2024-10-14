package br.com.veterinaria.petgabry.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pet")
public class Pet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
    private String nome;
	
	@Column(name="tipo")
    private String tipo;
	
	@Column(name="descricao")
    private String descricao;
	
	@Column(name="idVeterinaria")
    private String idVeterinaria;

	public Pet() {
	}

	public Pet(Integer id, String nome, String tipo, String descricao, String idVeterinaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.idVeterinaria = idVeterinaria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getIdVeterinaria() {
		return idVeterinaria;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", descricao=" + descricao + ", idVeterinaria="
				+ idVeterinaria + "]";
	}
}
