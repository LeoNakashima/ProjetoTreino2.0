package com.example.springProjeto.Controller;

import com.example.springProjeto.DTO.LoginRequest;
import com.example.springProjeto.DTO.LoginResponse;
import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping("/")
public class AlunoController {

    @Autowired
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;

    }


    @GetMapping("/selecionar")
    public List<Aluno> selecionarAluno() {
        return service.listarAlunos();
    }


    @PostMapping("/")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        boolean isValid = service.validarLogin(loginRequest.getEmail(), loginRequest.getSenha());

        if (isValid) {
            return new LoginResponse("Login concluido",true);
        }else {
            return new LoginResponse("Email ou senha incorretos",false);
        }
    }

}