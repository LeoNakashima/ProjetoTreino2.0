package com.example.springProjeto.Controller;

import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }


    @GetMapping("/selecionar")
    public ResponseEntity<List<Aluno>> selecionarAluno() {
        return ResponseEntity.ok(service.listarAlunos());
    }
}
