package models;

import java.time.LocalDate;

public class Alunos extends Pessoa {
   private Turma turma;
   private String matricula;

    public Alunos(String nome, String cpf, LocalDate dataNascimento, Turma turma, String matricula) {
        super(nome, cpf, dataNascimento);
        this.turma = turma;
        this.matricula = matricula;
    }

    public Alunos(Turma turma, String matricula) {
        this.turma = turma;
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
