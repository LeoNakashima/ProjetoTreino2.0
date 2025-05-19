package com.example.springProjeto.DTO;

public class EditarRequest {
    private String nome;
    private String email;
    private int ano;
    private Character serie;
    private Double nota_exatas;
    private Double nota_linguagem;
    private Double nota_ciencias;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getAno() {
        return ano;
    }

    public Character getSerie() {
        return serie;
    }

    public Double getNota_exatas() {
        return nota_exatas;
    }

    public Double getNota_linguagem() {
        return nota_linguagem;
    }

    public Double getNota_ciencias() {
        return nota_ciencias;
    }
}
