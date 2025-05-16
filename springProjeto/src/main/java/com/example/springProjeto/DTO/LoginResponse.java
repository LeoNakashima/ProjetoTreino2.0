package com.example.springProjeto.DTO;

public class LoginResponse {
    private String mensagem;
    private boolean sucesso;

    public LoginResponse(String mensagem, boolean sucesso) {
        this.mensagem = mensagem;
        this.sucesso = sucesso;
    }
    public String getMensagem() {
        return this.mensagem;
    }
    public boolean isSucesso() {
        return this.sucesso;
    }

}
