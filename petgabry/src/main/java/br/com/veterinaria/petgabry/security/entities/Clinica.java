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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "horario_funcionamento")
    private String horarioFuncionamento;

    @Column(name = "entity_type")
    private EnumType enumType;

    @OneToMany(mappedBy = "clinica")
    private Set<Pet> pets = new HashSet<>();

    public Clinica() {}

    public Clinica(int id, String nome, User user, String horarioFuncionamento, EnumType entityType) {
        this.id = id;
        this.nome = nome;
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
		return "Clinica [id=" + id + ", nome=" + nome + ", user=" + user
				+ ", horarioFuncionamento=" + horarioFuncionamento + ", enumType=" + enumType + ", pets=" + pets + "]";
	}
    
    
}
