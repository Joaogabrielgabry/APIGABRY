package br.com.veterinaria.petgabry.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.veterinaria.petgabry.security.dto.MessageResponseDTO;
import br.com.veterinaria.petgabry.security.dto.PetDTO;
import br.com.veterinaria.petgabry.security.entities.Pet;
import br.com.veterinaria.petgabry.security.services.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	PetService petService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarPet(@RequestBody PetDTO pet){
		petService.cadastrarPet(pet);
		return ResponseEntity.ok(new MessageResponseDTO("Pet cadastrado com sucesso!"));
	}
	
	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<String> deletarId(@PathVariable int id){
		boolean resultDelete = petService.petDelete(id);
		if(resultDelete) {
			return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao deletar objeto");
		}
	}
	
	@GetMapping("/listar")
	public List<Pet> listaPet(){
		return petService.petList();
	}
}
