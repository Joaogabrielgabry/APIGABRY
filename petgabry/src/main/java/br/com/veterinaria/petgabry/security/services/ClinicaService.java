package br.com.veterinaria.petgabry.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.dto.ClinicaRequestDTO;
import br.com.veterinaria.petgabry.security.entities.Clinica;
import br.com.veterinaria.petgabry.security.entities.Endereco;
import br.com.veterinaria.petgabry.security.repositories.ClinicaRepository;
import br.com.veterinaria.petgabry.security.repositories.EnderecoRepository;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private EnderecoService enderecoService;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Clinica cadastrarClinica(ClinicaRequestDTO clinicaDto) {
        Endereco endereco = enderecoService.consultarEndereco(clinicaDto.getEndereco()).toEndereco();
        enderecoRepository.save(endereco);
        Clinica clinica = new Clinica();
        clinica.setNome(clinicaDto.getNome());
        clinica.setHorarioFuncionamento(clinicaDto.getHorarioFuncionamento());
        clinica.setEndereco(endereco);

        return clinicaRepository.save(clinica); 
    }

    public List<Clinica> listarClinicas() {
        return clinicaRepository.findAll();
    }

    public Clinica buscarClinicaPorId(int id) {
        return clinicaRepository.findById(id).orElse(null);
    }

    public boolean atualizarClinica(int id, ClinicaRequestDTO clinicaDto) {
        Optional<Clinica> optionalClinica = clinicaRepository.findById(id);
        if (optionalClinica.isPresent()) {
            Clinica clinicaExistente = optionalClinica.get();

            clinicaExistente.setNome(clinicaDto.getNome());
            clinicaExistente.setHorarioFuncionamento(clinicaDto.getHorarioFuncionamento());

            Endereco endereco = enderecoService.consultarEndereco(clinicaDto.getEndereco()).toEndereco();
            clinicaExistente.setEndereco(endereco);

            clinicaRepository.save(clinicaExistente);
            return true;
        }
        return false;
    }

    public boolean deletarClinica(int id) {
        if (clinicaRepository.existsById(id)) {
            clinicaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}