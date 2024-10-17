package br.com.veterinaria.petgabry.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "end_tx_cep")
    private String cep;

    @Column(name = "end_tx_logradouro")
    private String logradouro;

    @Column(name = "end_tx_bairro")
    private String bairro;

    @Column(name = "end_tx_estado")
    private String estado;
    
    @Column(name = "end_tx_localidade")
    private String localidade;

    @Column(name = "end_tx_uf")
    private String uf;

    @Column(name = "end_tx_complemento")
    private String complemento;
    
    @Column(name = "end_tx_regiao")
    private String regiao;

    @Column(name = "end_int_numero")
    private int numero;

    public Endereco() {}

    public Endereco(Long id, String cep, String logradouro, String bairro, String localidade, String uf, String complemento, int numero, String estado, String regiao) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
        this.estado = estado;
        this.regiao = regiao;
    }

	public Endereco(String bairro, String cep, String complemento, String estado, String localidade,
			String logradouro, int numero, String regiao, String uf) {
		
		this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
        this.estado = estado;
        this.regiao = regiao;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Long getId() {
        return id;
    }

    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", estado="
				+ estado + ", localidade=" + localidade + ", uf=" + uf + ", complemento=" + complemento + ", regiao="
				+ regiao + ", numero=" + numero + "]";
	}
    
}
