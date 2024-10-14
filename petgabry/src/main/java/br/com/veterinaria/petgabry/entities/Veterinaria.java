package br.com.veterinaria.petgabry.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="veterinaria")
public class Veterinaria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vet_cd_id")
	private Integer id;
	
	@Column(name="vet_tx_nome_completo")
	private String nomeCompleto;
	
	@Column(name="vet_int_cpf")
	private Long cpf;

	public Veterinaria() {
	}

	public Veterinaria(Integer id, String nomeCompleto, Long cpf) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Veterinaria [id=" + id + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + "]";
	}
	
}
