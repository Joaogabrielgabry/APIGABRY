package br.com.veterinaria.petgabry.security.entities;

import java.util.HashSet;
import java.util.Set;

import br.com.veterinaria.petgabry.security.enums.EnumType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeclinica")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "horario_funcionamento")
    private String horarioFuncionamento;

    @Column(name = "entity_type")
    private EnumType enumType;

    @ManyToMany
    @JoinTable(
        name = "clinica_pet",
        joinColumns = @JoinColumn(name = "clinica_id"),
        inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<Pet> pets = new HashSet<>();

    public Clinica() {}

    public Clinica(int id, String nome, Endereco endereco, User user, String horarioFuncionamento, EnumType entityType) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.user = user;
        this.horarioFuncionamento = horarioFuncionamento;
        this.enumType = entityType;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public User getUser() {
        return user;
    }

    public EnumType getEnumType() {
        return enumType;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

	@Override
	public String toString() {
		return "Clinica [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", user=" + user
				+ ", horarioFuncionamento=" + horarioFuncionamento + ", enumType=" + enumType + ", pets=" + pets + "]";
	}
    
    
}
