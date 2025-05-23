package com.example.springProjeto.Service;

import com.example.springProjeto.DTO.CadastroLoginRequest;
import com.example.springProjeto.DTO.CadastroRequest;
import com.example.springProjeto.DTO.EditarRequest;
import com.example.springProjeto.Model.Aluno;
import com.example.springProjeto.Repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> produtos = alunoRepository.findAll();
        return produtos;
    }
    public boolean validarLogin(String email, String senha) {
        return alunoRepository.findAlunoByEmailAndSenha(email, senha).isPresent();
    }

    public boolean validarAluno(String email){

        return alunoRepository.existsByEmail(email);
    }
    public boolean Alunoexistir(Long id){
        return alunoRepository.findById(id).isPresent();

    }

    public void cadastrarAlunoLogin(CadastroLoginRequest cadastroLoginRequest){
        Aluno aluno = new Aluno(cadastroLoginRequest.getEmail(), cadastroLoginRequest.getSenha(), cadastroLoginRequest.getNome(), cadastroLoginRequest.getGenero(),cadastroLoginRequest.getData_nascimento(), cadastroLoginRequest.getTipo_alimentacao());
        alunoRepository.save(aluno);
    }
    public void cadastrarAluno(CadastroRequest cadastroRequest){
        Aluno aluno = new Aluno(cadastroRequest.getEmail(), cadastroRequest.getSenha(), cadastroRequest.getNome(), cadastroRequest.getGenero(),cadastroRequest.getData_nascimento(), cadastroRequest.getTipo_alimentacao(),cadastroRequest.getEscolaridade_pais(), cadastroRequest.getNota_linguagens(), cadastroRequest.getNota_exatas(), cadastroRequest.getNota_ciencias(),cadastroRequest.getSerie(),cadastroRequest.getAno());
        alunoRepository.save(aluno);
    }

    public void editarAluno(EditarRequest editarRequest) {
        Optional<Aluno> optionalAluno = alunoRepository.findAlunoByEmail(editarRequest.getEmail());

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();

            if (editarRequest.getNome() != null) {
                aluno.setNome(editarRequest.getNome());
            }
            if (editarRequest.getSerie() != null) {
                aluno.setSerie(editarRequest.getSerie());
            }
            if (editarRequest.getNota_exatas() != null) {
                aluno.setNota_exatas(editarRequest.getNota_exatas());
            }
            if (editarRequest.getNota_linguagem() != null) {
                aluno.setNota_linguagens(editarRequest.getNota_linguagem());
            }
            if (editarRequest.getNota_ciencias() != null) {
                aluno.setNota_ciencias(editarRequest.getNota_ciencias());
            }

            alunoRepository.save(aluno);
        } else {
            throw new RuntimeException("Aluno não encontrado com o e-mail fornecido.");
        }
    }


    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }


}