package br.com.veterinaria.petgabry.security.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "veterinaria_id")
    private Veterinaria veterinaria;

    @OneToOne
    @JoinColumn(name = "dono_id")
    private Dono dono;

    @OneToMany(mappedBy = "pet")
    private List<Consulta> consultas;

    public Pet() {}

    public Pet(Integer id, String nome, String tipo, String descricao, Veterinaria veterinaria, Dono dono) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.veterinaria = veterinaria;
        this.dono = dono;
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

    public Veterinaria getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Veterinaria veterinaria) {
        this.veterinaria = veterinaria;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", descricao=" + descricao + ", veterinaria=" + veterinaria + ", dono=" + dono + "]";
    }
}
