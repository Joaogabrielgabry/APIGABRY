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
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private Long cpf;
	
	@Column(name="especialidade")
	private String especialidade;
	
	@Column(name="petId")
	private int petId; 
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="horarioFuncionamento")
    private String horarioFuncionamento;

	public Veterinaria() {
	}

	public Veterinaria(Integer id, String nome, Long cpf, String especialidade, int petId, String endereco,
			String horarioFuncionamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.especialidade = especialidade;
		this.petId = petId;
		this.endereco = endereco;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public int getPetId() {
		return petId;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	@Override
	public String toString() {
		return "Veterinaria [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", especialidade=" + especialidade
				+ ", petId=" + petId + ", endereco=" + endereco + ", horarioFuncionamento=" + horarioFuncionamento
				+ "]";
	}
}
