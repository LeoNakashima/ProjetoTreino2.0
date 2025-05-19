package com.example.springProjeto.Service;

import com.example.springProjeto.DTO.CadastroRequest;
import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public boolean validarLogin(String email, String senha) {
        return alunoRepository.findAlunoByEmailAndSenha(email, senha).isPresent();}

    public boolean validarAluno(String email){
        return alunoRepository.existsByEmail(email);
    }

    public void cadastrarAlunoLogin(CadastroRequest cadastroRequest){
        Aluno aluno = new Aluno(cadastroRequest.getEmail(), cadastroRequest.getSenha(), cadastroRequest.getNome(), cadastroRequest.getGenero(),cadastroRequest.getData_nascimento(), cadastroRequest.getTipo_alimentacao());
        alunoRepository.save(aluno);
    }
    public void cadastrarAluno(CadastroRequest cadastroRequest){
        Aluno aluno = new Aluno(cadastroRequest.getEmail(), cadastroRequest.getSenha(), cadastroRequest.getNome(), cadastroRequest.getGenero(),cadastroRequest.getData_nascimento(), cadastroRequest.getTipo_alimentacao(),cadastroRequest.getEscolaridade_pais(), cadastroRequest.getNota_linguagens(), cadastroRequest.getNota_exatas(), cadastroRequest.getNota_ciencias());
        alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }

//    public void atualizarAluno(Long id, CadastroRequest cadastroRequest) {
//        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
//
//        if (optionalAluno.isPresent()) {
//            Aluno aluno = optionalAluno.get();
//
//            aluno.setNome(cadastroRequest.getNome());
//            aluno.setEmail(cadastroRequest.getEmail());
//
//            alunoRepository.save(aluno);
//        } else {
//            throw new RuntimeException("Aluno não encontrado");
//        }
//    }





}