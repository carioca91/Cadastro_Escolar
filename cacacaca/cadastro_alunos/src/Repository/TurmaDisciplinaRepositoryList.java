package Repository;

import models.Disciplina;
import models.Professor;
import models.Turma;
import models.TurmaDisciplina;

import java.util.ArrayList;
import java.util.List;

public class TurmaDisciplinaRepositoryList implements TurmaDisciplinaRepository {

    private List<TurmaDisciplina> turmaDisciplinas;

    public TurmaDisciplinaRepositoryList() {
        turmaDisciplinas = new ArrayList<>();
    }

    public void cadastrar(TurmaDisciplina turmaDisciplina) {
        turmaDisciplinas.add(turmaDisciplina);
    }

    public TurmaDisciplina buscar(Disciplina disciplina, Turma turma, Professor professor) {
        for (int i = 0; i < turmaDisciplinas.size(); i++) {
            TurmaDisciplina td = turmaDisciplinas.get(i);
            if (td.getDisciplina().equals(disciplina) &&
                    td.getTurma().equals(turma) &&
                    td.getProfessor().equals(professor)) {
                return td;
            }
        }
        return null;
    }

    public void atualizar(TurmaDisciplina antiga, TurmaDisciplina nova) {
        for (int i = 0; i < turmaDisciplinas.size(); i++) {
            if (turmaDisciplinas.get(i).equals(antiga)) {
                turmaDisciplinas.set(i, nova);
                System.out.println("TurmaDisciplina atualizada com sucesso!");
                return;
            }
        }
        System.out.println("TurmaDisciplina não encontrada para atualizar");
    }

    public void deletar(TurmaDisciplina td) {
        for (int i = 0; i < turmaDisciplinas.size(); i++) {
            if (turmaDisciplinas.get(i).equals(td)) {
                turmaDisciplinas.remove(i);
                System.out.println("TurmaDisciplina deletada com sucesso!");
                return;
            }
        }
        System.out.println("TurmaDisciplina não encontrada para deletar");
    }

    public List<TurmaDisciplina> buscarTodos() {
        return turmaDisciplinas;
    }

}
