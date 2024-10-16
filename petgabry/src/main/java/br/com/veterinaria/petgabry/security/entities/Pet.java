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
import jakarta.persistence.ManyToMany;
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

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nomedono")
    private String nomeDono;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "entity_type")
    private EnumType enumType;

    @ManyToMany(mappedBy = "pets")
    private Set<Clinica> clinicas = new HashSet<>();

    public Pet() {}

    public Pet(int id, String nomePet, String tipo, String descricao, String nomeDono, Endereco endereco, User user, EnumType entityType) {
        this.id = id;
        this.nomePet = nomePet;
        this.tipo = tipo;
        this.descricao = descricao;
        this.nomeDono = nomeDono;
        this.endereco = endereco;
        this.user = user;
        this.enumType = entityType;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public User getUser() {
        return user;
    }

    public EnumType getEnumType() {
        return enumType;
    }

    public Set<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(Set<Clinica> clinicas) {
        this.clinicas = clinicas;
    }

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nomePet=" + nomePet + ", tipo=" + tipo + ", descricao=" + descricao + ", nomeDono="
				+ nomeDono + ", endereco=" + endereco + ", user=" + user + ", enumType=" + enumType + ", clinicas="
				+ clinicas + "]";
	}
    
    
}
