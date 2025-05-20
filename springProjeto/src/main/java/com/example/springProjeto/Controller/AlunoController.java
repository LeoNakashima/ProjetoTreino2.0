package com.example.springProjeto.Controller;

import com.example.springProjeto.DTO.*;

import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
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
    public Response cadastro(@RequestBody CadastroLoginRequest cadastrologin){
        boolean isValid = service.validarAluno(cadastrologin.getEmail());

        if(isValid){
            return new Response("Usuário já existe",false);
        }
        else {
            service.cadastrarAlunoLogin(cadastrologin);
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

    @DeleteMapping("/excluir-aluno/{id}")
    public void excluir(@PathVariable Long id){
        service.deletarAluno(id);



    }

    @PatchMapping("/editar/{id}")
    public Response editarAluno(@PathVariable Long id,@RequestBody EditarRequest editarRequest) {
        try{
            service.editarAluno(editarRequest);
            return new Response("Atualizado",true);

        }
        catch (RuntimeException e) {
            return  new Response("Não erro",false);
        }

    }







}