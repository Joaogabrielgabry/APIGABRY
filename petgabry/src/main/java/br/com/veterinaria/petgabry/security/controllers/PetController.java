package br.com.veterinaria.petgabry.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.veterinaria.petgabry.security.dto.FinalizaCadastroDTO;
import br.com.veterinaria.petgabry.security.dto.MessageResponseDTO;
import br.com.veterinaria.petgabry.security.dto.PetDTO;
import br.com.veterinaria.petgabry.security.dto.PetInfoDTO;
import br.com.veterinaria.petgabry.security.dto.PetResponseDTO;
import br.com.veterinaria.petgabry.security.entities.Pet;
import br.com.veterinaria.petgabry.security.services.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	PetService petService;
	
	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/cadastrar")
	@Operation(summary = "Adiciona um novo Pet e faz as analogias com o usuario(dono) e a clinica")
	public ResponseEntity<?> cadastrarPet(@RequestBody PetDTO pet){
		petService.cadastrarPet(pet);
		return ResponseEntity.ok(new MessageResponseDTO("Pet cadastrado com sucesso!"));
	}
	
	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/deleteId/{id}")
	@Operation(summary = "Deleta um pet pelo id")
	public ResponseEntity<String> deletarId(@PathVariable int id){
		boolean resultDelete = petService.petDelete(id);
		if(resultDelete) {
			return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao deletar objeto");
		}
	}
	
	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/listar")
	@Operation(summary = "Lista todos os pets cadastrados")
	public List<Pet> listaPet(){
		return petService.petList();
	}
	
	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/finalizacadastro")
	@Operation(summary = "Finaliza o cadastro do pet usando nome do pet e nome do dono, e adiciona características adicionais")
	public ResponseEntity<PetResponseDTO> finalizaCadastro(@RequestBody FinalizaCadastroDTO request) {
	    PetResponseDTO petResponse = petService.finalizarCadastro(request);
	    return ResponseEntity.ok(petResponse);
	}
	
	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza os dados de um pet pelo ID")
    public ResponseEntity<?> atualizarPet(@PathVariable int id, @RequestBody PetDTO pet) {
        boolean atualizado = petService.atualizarPet(id, pet);
        if (atualizado) {
            return ResponseEntity.ok(new MessageResponseDTO("Pet atualizado com sucesso!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado.");
        }
    }
	
	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/listar-com-info")
	@Operation(summary = "Lista todos os pets com nome, serviço e raça")
	public ResponseEntity<List<PetInfoDTO>> listarPetsComInfo() {
	    List<PetInfoDTO> petInfoList = petService.listarPetsComInformacoes();
	    return ResponseEntity.ok(petInfoList);
	}

	@SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/listar-por-usuario/{userId}")
	@Operation(summary = "Lista todos os pets de um usuário pelo ID")
	public ResponseEntity<List<Pet>> listarPetsPorUsuario(@PathVariable int userId) {
	    List<Pet> pets = petService.listarPetsPorUsuario(userId);
	    if (pets.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pets);
	    }
	    return ResponseEntity.ok(pets);
	}
}
