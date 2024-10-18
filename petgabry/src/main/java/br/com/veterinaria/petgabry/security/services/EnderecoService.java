package br.com.veterinaria.petgabry.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.dto.EnderecoRequestDTO;
import br.com.veterinaria.petgabry.security.dto.EnderecoResponseDTO;
import br.com.veterinaria.petgabry.security.entities.Endereco;
import br.com.veterinaria.petgabry.security.repositories.EnderecoRepository;
import br.com.veterinaria.petgabry.utils.Util;

@Service
public class EnderecoService {

	@Autowired
	Util util;

	@Autowired
	EnderecoRepository enderecoRepository;

//  public EnderecoResponseDTO consultarEndereco(String cep, int numero, String complemento) {
//
//    EnderecoResponseDTO viaCep = util.buscarEndereco(cep); 
//    EnderecoResponseDTO endereco = new EnderecoResponseDTO(); 
//
//    endereco.setCep(viaCep.getCep());
//    endereco.setBairro(viaCep.getBairro()); 
//    endereco.setComplemento(viaCep.getComplemento());
//    endereco.setEstado(viaCep.getEstado());
//    endereco.setLocalidade(viaCep.getLocalidade());
//    endereco.setLogradouro(viaCep.getLogradouro());
//    endereco.setRegiao(viaCep.getRegiao());
//    endereco.setUf(viaCep.getUf());
//    endereco.setNumero(numero);
//
//    return endereco;
//  }

	public EnderecoResponseDTO consultarEndereco(EnderecoRequestDTO enderecoDto) {

		EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoDto.getCep());
		EnderecoResponseDTO endereco = new EnderecoResponseDTO();

		endereco.setCep(viaCep.getCep());
		endereco.setBairro(viaCep.getBairro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(viaCep.getEstado());
		endereco.setLocalidade(viaCep.getLocalidade());
		endereco.setLogradouro(viaCep.getLogradouro());
		endereco.setRegiao(viaCep.getRegiao());
		endereco.setUf(viaCep.getUf());
		endereco.setNumero(enderecoDto.getNumero());

		Endereco enderecoConvertido = endereco.toEndereco();
		enderecoRepository.save(enderecoConvertido);
		return endereco;
	}

	public EnderecoResponseDTO buscarEndereco(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
		enderecoResponseDTO.setCep(endereco.get().getCep());
		enderecoResponseDTO.setBairro(endereco.get().getBairro());
		enderecoResponseDTO.setComplemento(endereco.get().getComplemento());
		enderecoResponseDTO.setEstado(endereco.get().getEstado());
		enderecoResponseDTO.setLocalidade(endereco.get().getLocalidade());
		enderecoResponseDTO.setLogradouro(endereco.get().getLogradouro());
		enderecoResponseDTO.setRegiao(endereco.get().getRegiao());
		enderecoResponseDTO.setUf(endereco.get().getUf());
		enderecoResponseDTO.setNumero(endereco.get().getNumero());
		return enderecoResponseDTO;
	}
}
