package br.com.veterinaria.petgabry.security.controllers;

import java.util.List;

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

import br.com.veterinaria.petgabry.security.dto.ClinicaRequestDTO;
import br.com.veterinaria.petgabry.security.entities.Clinica;
import br.com.veterinaria.petgabry.security.services.ClinicaService;
import br.com.veterinaria.petgabry.security.services.EnderecoService;
@RestController
@RequestMapping("/clinica")
public class ClinicaController {
	
	@Autowired
	EnderecoService enderecoService;

	@Autowired
	private ClinicaService clinicaService;

	 @PostMapping("/cadastrar")
	    public ResponseEntity<Clinica> cadastrarClinica(@RequestBody ClinicaRequestDTO clinicaRequestDTO) {
	        Clinica clinica = clinicaService.cadastrarClinica(clinicaRequestDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(clinica);
	    }

	    @GetMapping("/listar")
	    public List<Clinica> listarClinicas() {
	        return clinicaService.listarClinicas();
	    }

	    @GetMapping("/buscar/{id}")
	    public ResponseEntity<Clinica> buscarClinicaPorId(@PathVariable int id) {
	        Clinica clinica = clinicaService.buscarClinicaPorId(id);
	        if (clinica != null) {
	            return ResponseEntity.ok(clinica);
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }

	    @PutMapping("/atualizar/{id}")
	    public ResponseEntity<String> atualizarClinica(@PathVariable int id, @RequestBody ClinicaRequestDTO clinicaRequestDTO) {
	        boolean atualizado = clinicaService.atualizarClinica(id, clinicaRequestDTO);
	        if (atualizado) {
	            return ResponseEntity.ok("Clínica atualizada com sucesso!");
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
	    }

	    @DeleteMapping("/deletar/{id}")
	    public ResponseEntity<String> deletarClinica(@PathVariable int id) {
	        boolean deletado = clinicaService.deletarClinica(id);
	        if (deletado) {
	            return ResponseEntity.ok("Clínica deletada com sucesso!");
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
	    }
	}

