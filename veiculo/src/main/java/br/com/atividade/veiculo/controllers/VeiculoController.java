package br.com.atividade.veiculo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atividade.veiculo.entities.Veiculo;
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private List<Veiculo> veiculos = new ArrayList<>();
    
    private Long idCounter = 1L;
    @PostMapping
    public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
        veiculo.setId(idCounter++);
        veiculos.add(veiculo);
        return veiculo;
    }
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }
    @GetMapping("/{id}")
    public Veiculo buscarVeiculo(@PathVariable Long id) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @PutMapping("/{id}")
    public Veiculo atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculo = buscarVeiculo(id);
        if (veiculo != null) {
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculo.setModelo(veiculoAtualizado.getModelo());
        }
        return veiculo;
    }
    @DeleteMapping("/{id}")
    public String removerVeiculo(@PathVariable Long id) {
        Veiculo veiculo = buscarVeiculo(id);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            return "Veículo removido com sucesso!";
        }
        return "Veículo não encontrado!";
    }
}
