package com.example.springProjeto.Controller;

import com.example.springProjeto.DTO.CadastroRequest;

import com.example.springProjeto.DTO.LoginRequest;
import com.example.springProjeto.DTO.Response;
import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    public Response login(@RequestBody LoginRequest loginRequest) {
        boolean isValid = service.validarLogin(loginRequest.getEmail(), loginRequest.getSenha());

        if (isValid) {
            return new Response("Login concluido",true);
        }else {
            return new Response("Email ou senha incorretos",false);
        }
    }

    @PostMapping("/cadastro-login")
    public Response cadastro(@RequestBody CadastroRequest cadastroRequest){
        boolean isValid = service.validarAluno(cadastroRequest.getEmail());

        if(isValid){
            return new Response("Usuário já existe",false);
        }
        else {
            service.cadastrarAlunoLogin(cadastroRequest);
            return new Response("Usuário cadastrado",true);
        }
    }

    @PostMapping("/cadastro-notas")
    public Response cadastroNotas(@RequestBody CadastroRequest cadastroRequest){
        boolean isValid = service.validarAluno(cadastroRequest.getEmail());

        if(isValid){
            return new Response("Usuário já existe",false);
        }
        else {
            service.cadastrarAluno(cadastroRequest);
            return new Response("Usuário cadastrado",true);
        }
    }

    @DeleteMapping("/excluir-aluno")
    public Response excluir(@PathVariable Long id,@RequestBody CadastroRequest cadastroRequest){
       boolean isValid = service.validarAluno(cadastroRequest.getEmail());

       if (isValid){
           service.deletarAluno(id);
           return new Response("Usuario deletado",true);
       }
       else{
           return new Response("Usuario não existe",false);
       }

    }

    @PutMapping("/editar-aluno")
    public Response atualizar(@PathVariable Long id, @RequestBody CadastroRequest cadastroRequest) {
        boolean isValid = service.validarAluno(cadastroRequest.getEmail());

        if (isValid) {
            service.atualizarAluno(id, cadastroRequest);
            return new Response("Usuário atualizado com sucesso", true);
        } else {
            return new Response("Usuário não existe", false);
        }
    }







}