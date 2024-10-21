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
    private Util util;

    @Autowired
    private EnderecoRepository enderecoRepository;

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
        Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
 
        Endereco endereco = enderecoOpt.orElseThrow(() -> 
            new RuntimeException("Endereço não encontrado com o ID: " + id)
        );
        
        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        enderecoResponseDTO.setCep(endereco.getCep());
        enderecoResponseDTO.setBairro(endereco.getBairro());
        enderecoResponseDTO.setComplemento(endereco.getComplemento());
        enderecoResponseDTO.setEstado(endereco.getEstado());
        enderecoResponseDTO.setLocalidade(endereco.getLocalidade());
        enderecoResponseDTO.setLogradouro(endereco.getLogradouro());
        enderecoResponseDTO.setRegiao(endereco.getRegiao());
        enderecoResponseDTO.setUf(endereco.getUf());
        enderecoResponseDTO.setNumero(endereco.getNumero());

        return enderecoResponseDTO;
    }

    public Optional<Endereco> findById(Integer id) {
        return enderecoRepository.findById(id);
    }
}
