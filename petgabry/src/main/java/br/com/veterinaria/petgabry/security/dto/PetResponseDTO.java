package br.com.veterinaria.petgabry.security.dto;

public class PetResponseDTO {
    private int id;
    private String nomePet;
    private String tipo;
    private String servicoAtual;
    private String nomeDono;
    private String nomeClinica;


    public PetResponseDTO(int id, String nomePet, String tipo, String servicoAtual, String nomeDono, String nomeClinica) {
        this.id = id;
        this.nomePet = nomePet;
        this.tipo = tipo;
        this.servicoAtual = servicoAtual;
        this.nomeDono = nomeDono;
        this.nomeClinica = nomeClinica;
    }

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }
}
