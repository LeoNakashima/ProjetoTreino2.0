package com.example.springProjeto.DTO;

import java.sql.Date;

public class CadastroRequest {
    private String email;
    private String senha;
    private String nome;
    private String Genero;
    private Date data_nascimento;
    private String tipo_alimentacao;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return Genero;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getTipo_alimentacao() {
        return tipo_alimentacao;
    }
}
