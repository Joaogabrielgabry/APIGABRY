package br.com.veterinaria.petgabry.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomepet")
    private String nomePet;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "servico_atual")
    private String servicoAtual;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "clinica_id", referencedColumnName = "id")
    private Clinica clinica;


    public Pet() {}

    public Pet(int id, String nomePet, String tipo, String servicoAtual, User user, Clinica clinica) {
        this.id = id;
        this.nomePet = nomePet;
        this.tipo = tipo;
        this.servicoAtual = servicoAtual;
        this.user = user;
        this.clinica = clinica;
    }

    public int getId() {
        return id;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getServicoAtual() {
        return servicoAtual;
    }

    public void setServicoAtual(String servicoAtual) {
        this.servicoAtual = servicoAtual;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", nomePet=" + nomePet + ", tipo=" + tipo + ", servico atual =" + servicoAtual + ", user="
                + user + ", clinica=" + clinica + "]";
    }
}
