package models;

public class TurmaDisciplina {
    private Disciplina disciplina;
    private Turma turma;
    private Professor professor;

    public TurmaDisciplina(Disciplina disciplina, Turma turma, Professor professor) {
        this.disciplina = disciplina;
        this.turma = turma;
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "TurmaDisciplina{" +
                "disciplina=" + disciplina +
                ", turma=" + turma +
                ", professor=" + professor +
                '}';
    }
}
