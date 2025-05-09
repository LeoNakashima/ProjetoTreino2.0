package com.example.springProjeto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String sobrenome;
    private String Genero;
    private String email;
    private String senha;
    private Date data_nascimento;
    private String escolaridade_pais;
    private String tipo_alimentacao;
    private double notas_exatas;
    private double notas_linguagem;
    private double notas_ciencias;
    private double media_geral;
    private int rank_geral;
    private String desempenho;
    private String status_exatas;
    private String status_linguagem;
    private String status_ciencias;
    private String status_final;

    public Aluno(){}

    public Aluno(String nome, String sobrenome, String genero,String email, String senha, Date data_nascimento, String escolaridade_pais, String tipo_alimentacao, double notas_exatas, double notas_linguagem, double notas_ciencias, double media_geral, int rank_geral, String desempenho, String status_exatas, String status_linguagem, String status_ciencias, String status_final) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.Genero = genero;
        this.email= email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.escolaridade_pais = escolaridade_pais;
        this.tipo_alimentacao = tipo_alimentacao;
        this.notas_exatas = notas_exatas;
        this.notas_linguagem = notas_linguagem;
        this.notas_ciencias = notas_ciencias;
        this.media_geral = media_geral;
        this.rank_geral = rank_geral;
        this.desempenho = desempenho;
        this.status_exatas = status_exatas;
        this.status_linguagem = status_linguagem;
        this.status_ciencias = status_ciencias;
        this.status_final = status_final;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public String getGenero() {
        return this.Genero;
    }

    public Date getData_nascimento() {
        return this.data_nascimento;
    }

    public String getEscolaridade_pais() {
        return this.escolaridade_pais;
    }

    public String getTipo_alimentacao() {
        return this.tipo_alimentacao;
    }

    public double getNotas_exatas() {
        return this.notas_exatas;
    }

    public double getNotas_linguagem() {
        return this.notas_linguagem;
    }

    public double getNotas_ciencias() {
        return this.notas_ciencias;
    }

    public double getMedia_geral() {
        return this.media_geral;
    }

    public int getRank_geral() {
        return this.rank_geral;
    }

    public String getDesempenho() {
        return this.desempenho;
    }

    public String getStatus_exatas() {
        return this.status_exatas;
    }

    public String getStatus_linguagem() {
        return this.status_linguagem;
    }

    public String getStatus_ciencias() {
        return this.status_ciencias;
    }

    public String getStatus_final() {
        return this.status_final;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setEscolaridade_pais(String escolaridade_pais) {
        this.escolaridade_pais = escolaridade_pais;
    }

    public void setTipo_alimentacao(String tipo_alimentacao) {
        this.tipo_alimentacao = tipo_alimentacao;
    }

    public void setNotas_exatas(double notas_exatas) {
        this.notas_exatas = notas_exatas;
    }

    public void setNotas_linguagem(double notas_linguagem) {
        this.notas_linguagem = notas_linguagem;
    }

    public void setNotas_ciencias(double notas_ciencias) {
        this.notas_ciencias = notas_ciencias;
    }

    public void setMedia_geral(double media_geral) {
        this.media_geral = media_geral;
    }

    public void setRank_geral(int rank_geral) {
        this.rank_geral = rank_geral;
    }

    public void setDesempenho(String desempenho) {
        this.desempenho = desempenho;
    }

    public void setStatus_exatas(String status_exatas) {
        this.status_exatas = status_exatas;
    }

    public void setStatus_linguagem(String status_linguagem) {
        this.status_linguagem = status_linguagem;
    }

    public void setStatus_ciencias(String status_ciencias) {
        this.status_ciencias = status_ciencias;
    }

    public void setStatus_final(String status_final) {
        this.status_final = status_final;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", Genero='" + Genero + '\'' +
                ", Email=" + email + '\''+
                ", Senha=" + senha + '\''+
                ", data_nascimento=" + data_nascimento +
                ", escolaridade_pais='" + escolaridade_pais + '\'' +
                ", tipo_alimentacao='" + tipo_alimentacao + '\'' +
                ", notas_exatas=" + notas_exatas +
                ", notas_linguagem=" + notas_linguagem +
                ", notas_ciencias=" + notas_ciencias +
                ", media_geral=" + media_geral +
                ", rank_geral=" + rank_geral +
                ", desempenho='" + desempenho + '\'' +
                ", status_exatas='" + status_exatas + '\'' +
                ", status_linguagem='" + status_linguagem + '\'' +
                ", status_ciencias='" + status_ciencias + '\'' +
                ", status_final='" + status_final + '\'' +
                '}';
    }
}
