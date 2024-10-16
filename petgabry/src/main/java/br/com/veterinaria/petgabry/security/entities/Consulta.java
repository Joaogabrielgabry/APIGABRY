package br.com.veterinaria.petgabry.security.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "veterinaria_id")
    private Veterinaria veterinaria;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @OneToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    public Consulta() {}

    public Consulta(Integer id, LocalDate data, Veterinaria veterinaria, Pet pet, Veterinario veterinario) {
        this.id = id;
        this.data = data;
        this.veterinaria = veterinaria;
        this.pet = pet;
        this.veterinario = veterinario;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    @Override
    public String toString() {
        return "Consulta [id=" + id + ", data=" + data + ", veterinaria=" + veterinaria + ", pet=" + pet + ", veterinario=" + veterinario + "]";
    }
}
