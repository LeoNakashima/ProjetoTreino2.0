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
            return new Response("Login concluido",true,HttpStatus.OK);
        }else {
            return new Response("Email ou senha incorretos",false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cadastro-login")
    public Response cadastro(@RequestBody CadastroLoginRequest cadastrologin){
        boolean isValid = service.validarAluno(cadastrologin.getEmail());

        if(isValid){
            return new Response("Usuário já existe",false,HttpStatus.CONFLICT);
        }
        else {
            service.cadastrarAlunoLogin(cadastrologin);
            return new Response("Usuário cadastrado",true,HttpStatus.OK);
        }
    }

    @PostMapping("/cadastro-notas")
    public Response cadastroNotas(@RequestBody CadastroRequest cadastroRequest){
        boolean isValid = service.validarAluno(cadastroRequest.getEmail());

        if(isValid){
            return new Response("Usuário já existe",false,HttpStatus.CONFLICT);
        }
        else {
            service.cadastrarAluno(cadastroRequest);
            return new Response("Usuário cadastrado",true, HttpStatus.OK);
        }
    }

    @DeleteMapping("/excluir-aluno/{id}")
    public Response excluir(@PathVariable Long id){
        boolean isValid = service.Alunoexistir(id);
        if(isValid){
            return new Response("Usuário não deletado",false,HttpStatus.NOT_FOUND);
        }
        else {
            service.deletarAluno(id);
            return new Response("Usuário deletado",true,HttpStatus.OK);
        }





    }

    @PatchMapping("/editar/{id}")
    public Response editarAluno(@PathVariable Long id,@RequestBody EditarRequest editarRequest) {
        boolean isValid = service.Alunoexistir(id);
        if(isValid){
            return new Response("Usuário não editado",false,HttpStatus.NOT_FOUND);
        }
        else {
            service.editarAluno(editarRequest);
            return new Response("Usuário editado",true,HttpStatus.OK);
        }

    }







}