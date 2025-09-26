package models;

public class Turma {
    private long idTurma;
    private String semestre;

    public Turma(long idTurma, String semestre) {
        this.idTurma = idTurma;
        this.semestre = semestre;
    }
    public Turma(){

    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }


}
