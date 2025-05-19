package com.example.springProjeto.Repository;

import com.example.springProjeto.DTO.CadastroRequest;
import com.example.springProjeto.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findAlunoByEmailAndSenha(String email, String senha);
    boolean existsByEmail(String email);
    Optional<Aluno> findAlunoByEmail(String email);


}


