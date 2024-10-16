package br.com.veterinaria.petgabry.security.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    @ManyToMany
    @JoinTable(
        name = "veterinario_especialidade",
        joinColumns = @JoinColumn(name = "veterinario_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
    private Set<Especialidade> especialidades;

    public Veterinario() {}

    public Veterinario(Integer id, String nome) {
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

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Set<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "Veterinario [id=" + id + ", nome=" + nome + ", especialidades=" + especialidades + "]";
    }
}
