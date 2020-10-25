package com.vbas.desafioTecnicoConcrete.model;

public class ErrorMessage {

    private String mensagem;

    public String getMessage() {
        return mensagem;
    }

    public ErrorMessage(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setMessage(String messagem) {
        this.mensagem = messagem;
    }
}
