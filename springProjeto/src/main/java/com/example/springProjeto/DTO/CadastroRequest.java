package com.example.springProjeto.DTO;

import java.sql.Date;

public class CadastroRequest {
    private String email;
    private String senha;
    private String nome;
    private String Genero;
    private Date data_nascimento;
    private String tipo_alimentacao;

    private String escolaridade_pais;
    private double nota_exatas;
    private double nota_linguagens;
    private double nota_ciencias;

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

    public double getNota_exatas() {
        return nota_exatas;
    }

    public double getNota_linguagens() {
        return nota_linguagens;
    }

    public double getNota_ciencias() {
        return nota_ciencias;
    }

    public String getEscolaridade_pais() {
        return escolaridade_pais;
    }
}
