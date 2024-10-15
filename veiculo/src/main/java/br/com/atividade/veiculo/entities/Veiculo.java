package br.com.atividade.veiculo.entities;

public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;

	public Veiculo() {}

    public Veiculo(Long id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}
