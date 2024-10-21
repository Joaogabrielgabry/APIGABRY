package br.com.veterinaria.petgabry.security.dto;

public class PetInfoDTO {
    private String nomePet;
    private String servico;
    private String raca;

    public PetInfoDTO(String nomePet, String servico, String raca) {
        this.nomePet = nomePet;
        this.servico = servico;
        this.raca = raca;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
