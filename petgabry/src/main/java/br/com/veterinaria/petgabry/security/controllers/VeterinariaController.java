package br.com.veterinaria.petgabry.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.veterinaria.petgabry.security.dto.EnderecoRequestDTO;
import br.com.veterinaria.petgabry.security.dto.EnderecoResponseDTO;
import br.com.veterinaria.petgabry.security.services.EnderecoService;
@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {
	
	@Autowired
	EnderecoService enderecoService;

//	@PostMapping("/buscar")
//	public EnderecoResponseDTO testeEndereco(@RequestParam String cep, @RequestParam int numero, @RequestParam String complemento) {
//	    return enderecoService.consultarEndereco(cep, numero, complemento);
//	}

	@PostMapping("/buscar")
	public EnderecoResponseDTO testeEndereco(@RequestBody EnderecoRequestDTO enderecoDTO) {
		return enderecoService.consultarEndereco(enderecoDTO);
	}

}

