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
        if (produtos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto encontrado.");
        }
        return produtos;
    }
    public boolean validarLogin(String email, String senha) {
        boolean alunoValido = alunoRepository.findAlunoByEmailAndSenha(email, senha).isPresent();
        if (alunoValido==false){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum aluno encontrado");
        }
        return alunoRepository.findAlunoByEmailAndSenha(email, senha).isPresent();
    }

    public boolean validarAluno(String email){
        boolean alunoExiste = alunoRepository.existsByEmail(email);
        if (alunoExiste==false){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Nenhum aluno encontrado");
        }
        return alunoRepository.existsByEmail(email);
    }

    public void cadastrarAlunoLogin(CadastroLoginRequest cadastroLoginRequest){
        Aluno aluno = new Aluno(cadastroLoginRequest.getEmail(), cadastroLoginRequest.getSenha(), cadastroLoginRequest.getNome(), cadastroLoginRequest.getGenero(),cadastroLoginRequest.getData_nascimento(), cadastroLoginRequest.getTipo_alimentacao());
        alunoRepository.save(aluno);
    }
    public void cadastrarAluno(CadastroRequest cadastroRequest){
        Aluno aluno = new Aluno(cadastroRequest.getEmail(), cadastroRequest.getSenha(), cadastroRequest.getNome(), cadastroRequest.getGenero(),cadastroRequest.getData_nascimento(), cadastroRequest.getTipo_alimentacao(),cadastroRequest.getEscolaridade_pais(), cadastroRequest.getNota_linguagens(), cadastroRequest.getNota_exatas(), cadastroRequest.getNota_ciencias());
        Aluno alunoCadastrado = alunoRepository.save(aluno);
        if (alunoCadastrado == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Falha ao cadastrar aluno");
        }
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

            alunoRepository.save(aluno); // Salva após todas as alterações
        } else {
            throw new RuntimeException("Aluno não encontrado com o e-mail fornecido.");
        }
    }


    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }


}