package br.com.veterinaria.petgabry.security.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "veterinaria")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private Long cpf;

    @OneToMany(mappedBy = "veterinaria")
    private List<Pet> pets;

    @ManyToMany
    @JoinTable(
        name = "veterinaria_especialidade",
        joinColumns = @JoinColumn(name = "veterinaria_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
    private Set<Especialidade> especialidades;

    @OneToMany(mappedBy = "veterinaria")
    private List<Consulta> consultas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private String endereco;

    @Column(name = "horarioFuncionamento")
    private String horarioFuncionamento;

    public Veterinaria() {}

	public Veterinaria(Integer id, String nome, Long cpf, List<Pet> pets, Set<Especialidade> especialidades,
			List<Consulta> consultas, String endereco, String horarioFuncionamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.pets = pets;
		this.especialidades = especialidades;
		this.consultas = consultas;
		this.endereco = endereco;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public Integer getId() {
		return id;
	}

	public Long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Veterinaria [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", pets=" + pets + ", especialidades="
				+ especialidades + ", consultas=" + consultas + ", endereco=" + endereco + ", horarioFuncionamento="
				+ horarioFuncionamento + "]";
	}

}
