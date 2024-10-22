package br.com.veterinaria.petgabry.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.veterinaria.petgabry.security.dto.EnderecoRequestDTO;
import br.com.veterinaria.petgabry.security.entities.Endereco;
import br.com.veterinaria.petgabry.security.entities.User;
import br.com.veterinaria.petgabry.security.repositories.EnderecoRepository;
import br.com.veterinaria.petgabry.security.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public boolean adicionarEndereco(String username, String password, EnderecoRequestDTO enderecoDto) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                Endereco endereco = new Endereco();
//                endereco = enderecoService.criarEndereco(enderecoDto); 
                endereco = enderecoService.consultarEndereco(enderecoDto).toEndereco();
                enderecoRepository.save(endereco);
                user.setEndereco(endereco);
                userRepository.save(user);   
                
                return true;
            }
        }
        return false;
    }

}
