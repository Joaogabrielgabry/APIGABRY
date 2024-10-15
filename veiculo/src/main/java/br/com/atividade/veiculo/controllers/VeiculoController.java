package br.com.atividade.veiculo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atividade.veiculo.entities.Veiculo;
import br.com.atividade.veiculo.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/veiculo")
@Tag(name = "Veículo", description = "API para gerenciar veículos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    @Operation(summary = "Adiciona um novo veículo")
    public ResponseEntity<Veiculo> adicionarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.adicionarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um veículo pelo ID")
    public ResponseEntity<Void> removerVeiculo(@PathVariable Integer id) {
        if (!veiculoService.buscarVeiculoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veiculoService.removerVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza as informações de um veículo pelo ID")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        if (!veiculoService.buscarVeiculoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        veiculo.setId(id);
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(veiculo);
        return ResponseEntity.ok(veiculoAtualizado);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um veículo pelo ID")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Integer id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return veiculo.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Lista todos os veículos")
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }
}