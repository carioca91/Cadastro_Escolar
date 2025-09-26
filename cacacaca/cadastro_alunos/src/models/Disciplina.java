package models;

public class Disciplina {
    private String nomeDisciplina;
    private long codDisciplina;
    private double notaMinima;
    private Professor professor;

    public Disciplina(String nomeDisciplina, long codDisciplina, double notaMinima) {
        this.nomeDisciplina = nomeDisciplina;
        this.codDisciplina = codDisciplina;
        this.notaMinima = notaMinima;
    }

    public Disciplina() {
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public long getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(long codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }


    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}