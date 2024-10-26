# APIGABRY

Sistema de Gestão Veterinária - PetGabry

O projeto Veterinária PetGabry é uma API REST desenvolvida em Java utilizando o framework Spring Boot para gerenciar uma clínica veterinária. Ele implementa funcionalidades para administração de clínicas, pets e usuários, além de oferecer um sistema de autenticação e autorização com segurança baseada em roles (perfis de usuário) via Spring Security. O projeto também conta com a documentação interativa das APIs usando Swagger.

Principais Funcionalidades:
    Gestão de Clínicas:
        Cadastro, atualização, listagem, e exclusão de clínicas.
        Associar endereço à clínica.

    Gestão de Pets:
        Cadastro de pets, associação com o dono (usuário) e clínica.
        Listagem de pets por usuário, além de operações para deletar e atualizar informações de pets.

    Gestão de Endereços:
        Cada usuário e clínica pode ter um endereço associado, com dados como CEP, logradouro, bairro, estado e número.

    Autenticação e Autorização:
        A segurança é gerenciada via JWT Tokens, com perfis de usuário (USER) que permitem acesso às operações de CRUD de pets e clínicas.
        Endpoints seguros, acessíveis somente com autenticação válida e autorização adequada.
        Documentação com Swagger:

A API conta com documentação utilizando o Swagger, permitindo a visualização e teste das rotas diretamente via interface gráfica.

Tecnologias Utilizadas:
    Java 17
    Spring Boot
    Spring Security (JWT e roles)
    Hibernate/JPA para persistência de dados
    MySQL (ou qualquer banco relacional compatível)
    Swagger/OpenAPI para documentação das APIs

Segurança
    A API utiliza JWT para autenticação. É necessário fazer login e obter um token antes de acessar os endpoints protegidos. O token deve ser enviado no cabeçalho de cada requisição:
        Authorization: Bearer <seu-token-jwt>

O projeto é ideal para clínicas veterinárias que precisam de um sistema robusto para gerenciar seus pets e clientes, com segurança integrada e flexibilidade para se adaptar a diferentes ambientes.

Autor João Gabriel Magalhães Gabry dos Reis Oliveira