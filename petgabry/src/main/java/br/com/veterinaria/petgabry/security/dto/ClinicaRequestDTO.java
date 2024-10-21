package br.com.veterinaria.petgabry.security.dto;

public class ClinicaRequestDTO {
    private String nome;
    private String horarioFuncionamento;
    private EnderecoRequestDTO endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public EnderecoRequestDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequestDTO endereco) {
        this.endereco = endereco;
    }
}
