package models;

import java.time.LocalDate;

public class Professor extends Pessoa{
    private String formacao;
    private Status status;
    private Titulacao titulacao;

    public Professor(String nome, String cpf, LocalDate dataNascimento, String formacao, Status status, Titulacao titulacao) {
        super(nome, cpf, dataNascimento);
        this.formacao = formacao;
        this.status = status;
        this.titulacao = titulacao;

    }

    public Professor() {
    }

    public Professor(String nome, String cpf, Status status, Titulacao titulacao) {
    }


    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }
}
