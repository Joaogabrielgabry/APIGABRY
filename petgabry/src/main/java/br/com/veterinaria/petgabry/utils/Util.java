package br.com.veterinaria.petgabry.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.veterinaria.petgabry.security.dto.EnderecoResponseDTO;

@Component
public class Util {

	public EnderecoResponseDTO buscarEndereco(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json", EnderecoResponseDTO.class, cep);
	}
}


