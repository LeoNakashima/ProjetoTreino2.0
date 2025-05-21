package com.example.springProjeto.DTO;

import org.springframework.http.HttpStatus;

public class Response {
    private String mensagem;
    private boolean sucesso;
    private HttpStatus error;

    public Response(String mensagem, boolean sucesso,HttpStatus error) {
        this.mensagem = mensagem;
        this.sucesso = sucesso;
        this.error = error;
    }
    public String getMensagem() {
        return this.mensagem;
    }
    public boolean isSucesso() {
        return this.sucesso;
    }
    public HttpStatus getError(){return this.error;}

}
