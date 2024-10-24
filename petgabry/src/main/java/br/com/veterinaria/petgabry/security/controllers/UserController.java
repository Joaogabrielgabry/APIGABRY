package br.com.veterinaria.petgabry.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.veterinaria.petgabry.security.dto.EnderecoRequestDTO;
import br.com.veterinaria.petgabry.security.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @SecurityRequirement(name="bearer Auth")
	@PreAuthorize("hasRole('USER')")
    @PostMapping("/adicionaEnderecoUser")
    public ResponseEntity<String> adicionaEndereco(
            @RequestParam String username,
            @RequestParam String password,
            @RequestBody EnderecoRequestDTO enderecoDto) {
        boolean enderecoAdicionado = userService.adicionarEndereco(username, password, enderecoDto);
        if (enderecoAdicionado) {
            return ResponseEntity.ok("Endereço cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação. Endereço não cadastrado!");
        }
    }
}
