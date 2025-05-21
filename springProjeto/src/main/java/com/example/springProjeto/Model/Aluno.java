package com.example.springProjeto.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "estudantes")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
   // private String sobrenome;
    private String genero;
    private String email;
    private String senha;
    private int ano;
    private Character serie;
    private Date data_nascimento;
    private String escolaridade_pais;
    private String tipo_alimentacao;
    private Double nota_exatas;
    private Double nota_linguagens;
    private Double nota_ciencias;
    private double media_geral;
    private int rank_geral;
    private String desempenho;
    private String status_exatas;
    private String status_linguagem;
    private String status_ciencias;
    private String status_final;

    public Aluno(){}

    public Aluno(String nome, String genero,String email, String senha, Date data_nascimento, String escolaridade_pais, String tipo_alimentacao, Double notas_exatas, Double notas_linguagens, Double notas_ciencias, double media_geral, int rank_geral, String desempenho, String status_exatas, String status_linguagem, String status_ciencias, String status_final) {
        this.nome = nome;
       // this.sobrenome = sobrenome;
        this.genero = genero;
        this.email= email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.escolaridade_pais = escolaridade_pais;
        this.tipo_alimentacao = tipo_alimentacao;
        this.nota_exatas = notas_exatas;
        this.nota_linguagens = notas_linguagens;
        this.nota_ciencias = notas_ciencias;
        this.media_geral = media_geral;
        this.rank_geral = rank_geral;
        this.desempenho = desempenho;
        this.status_exatas = status_exatas;
        this.status_linguagem = status_linguagem;
        this.status_ciencias = status_ciencias;
        this.status_final = status_final;
    }



    public Aluno(String nome, String genero,String email, String senha, Date data_nascimento, String tipo_alimentacao){
        this.email= email;
        this.senha = senha;
        this.nome = nome;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.tipo_alimentacao =tipo_alimentacao;

    }

    public Aluno(String nome, String genero,String email, String senha, Date data_nascimento, String tipo_alimentacao,String escolaridade_pais,Double nota_linguagens,Double nota_exatas,Double nota_ciencias ){
        this.email= email;
        this.senha = senha;
        this.nome = nome;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.tipo_alimentacao =tipo_alimentacao;
        this.escolaridade_pais = escolaridade_pais;
        this.nota_linguagens= nota_linguagens;
        this.nota_exatas=nota_exatas;
        this.nota_ciencias=nota_ciencias;

    }

    public Aluno(String nome,String email,int ano,Character serie,double nota_linguagens,double nota_exatas,double nota_ciencias ){
        this.nome = nome;
        this.email = email;
        this.ano = ano;
        this.serie = serie;
        this.nota_linguagens= nota_linguagens;
        this.nota_exatas=nota_exatas;
        this.nota_ciencias=nota_ciencias;

    }

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

//    public String getSobrenome() {
//        return this.sobrenome;
//    }

    public String getGenero() {
        return this.genero;
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

    public Double getNota_exatas() {
        return this.nota_exatas;
    }

    public Double getNota_linguagem() {
        return this.nota_linguagens;
    }

    public Double getNota_ciencias() {
        return this.nota_ciencias;
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

    public String getEmail() {
        return email;
    }

    public int getAno() {
        return ano;
    }

    public Character getSerie() {
        return serie;
    }

    public double getNota_linguagens() {
        return nota_linguagens;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public void setSobrenome(String sobrenome) {
//        this.sobrenome = sobrenome;
//    }

    public void setGenero(String genero) {
        genero = genero;
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

    public void setNota_exatas(double notas_exatas) {
        this.nota_exatas = notas_exatas;
    }

    public void setNota_linguagens(double notas_linguagens) {
        this.nota_linguagens = notas_linguagens;
    }

    public void setNota_ciencias(double notas_ciencias) {
        this.nota_ciencias = notas_ciencias;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setSerie(Character serie) {
        this.serie = serie;
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
                ", Genero='" + genero + '\'' +
                ", ano='" + ano + '\'' +
                ", serie='" + serie + '\'' +
                ", Email=" + email + '\''+
                ", Senha=" + senha + '\''+
                ", data_nascimento=" + data_nascimento +
                ", escolaridade_pais='" + escolaridade_pais + '\'' +
                ", tipo_alimentacao='" + tipo_alimentacao + '\'' +
                ", notas_exatas=" + nota_exatas +
                ", notas_linguagens=" + nota_linguagens +
                ", notas_ciencias=" + nota_ciencias +
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
