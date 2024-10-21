package br.com.veterinaria.petgabry.security.dto;

public class FinalizaCadastroDTO {
    private String nomePet;
    private String nomeDono;
    private String tipo;
    private String servicoAtual;

    // Getters e Setters
    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
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
}
