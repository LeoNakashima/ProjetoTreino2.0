package com.example.springProjeto.Controller;

import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }


    @GetMapping("/selecionar")
    public List<Aluno> selecionarAluno() {
       return service.listarAlunos();
    }


//    @PostMapping("/login")
//    public ResponseEntity<Void> login(@RequestBody Aluno aluno) {
//        boolean valido = service.validarLogin(aluno.getEmail(),aluno.getSenha());
//
//        if(valido){
//            return ResponseEntity.ok().build();
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//    }


}
