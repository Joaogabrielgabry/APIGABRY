package br.com.veterinaria.petgabry.entities;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "especialidades")
    private Set<Veterinaria> veterinarias;  

    public Especialidade() {}

    public Especialidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Veterinaria> getVeterinarias() {
        return veterinarias;
    }

    public void setVeterinarias(Set<Veterinaria> veterinarias) {
        this.veterinarias = veterinarias;
    }

    @Override
    public String toString() {
        return "Especialidade [id=" + id + ", nome=" + nome + "]";
    }
}
