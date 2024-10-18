package br.com.veterinaria.petgabry.security.entities;

import br.com.veterinaria.petgabry.security.enums.EnumType;
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

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nomedono")
    private String nomeDono;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "entity_type")
    private EnumType enumType;

    @ManyToOne
    @JoinColumn(name = "clinica_id") 
    private Clinica clinica;

    public Pet() {}

	public Pet(int id, String nomePet, String tipo, String descricao, String nomeDono, User user,
			EnumType enumType, Clinica clinica) {
		super();
		this.id = id;
		this.nomePet = nomePet;
		this.tipo = tipo;
		this.descricao = descricao;
		this.nomeDono = nomeDono;
		this.user = user;
		this.enumType = enumType;
		this.clinica = clinica;
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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EnumType getEnumType() {
		return enumType;
	}

	public void setEnumType(EnumType enumType) {
		this.enumType = enumType;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nomePet=" + nomePet + ", tipo=" + tipo + ", descricao=" + descricao + ", nomeDono="
				+ nomeDono + ", user=" + user + ", enumType=" + enumType + ", clinica="
				+ clinica + "]";
	}

    
}
