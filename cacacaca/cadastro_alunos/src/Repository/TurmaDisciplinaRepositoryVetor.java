package Repository;

import models.Disciplina;
import models.Professor;
import models.Turma;
import models.TurmaDisciplina;

import java.util.ArrayList;
import java.util.List;

public class TurmaDisciplinaRepositoryVetor implements TurmaDisciplinaRepository {

    private TurmaDisciplina[] turmaDisciplinas;

    public TurmaDisciplinaRepositoryVetor() {
        this.turmaDisciplinas = new TurmaDisciplina[100];
    }

    @Override
    public void cadastrar(TurmaDisciplina turmaDisciplina) {
        for (int i = 0; i < turmaDisciplinas.length; i++) {
            if (turmaDisciplinas[i] == null) {
                turmaDisciplinas[i] = turmaDisciplina;
                return;
            }
        }
    }

    @Override
    public TurmaDisciplina buscar(Disciplina disciplina, Turma turma, Professor professor) {
        for (int i = 0; i < turmaDisciplinas.length; i++) {
            TurmaDisciplina td = turmaDisciplinas[i];
            if (td != null &&
                    td.getDisciplina().equals(disciplina) &&
                    td.getTurma().equals(turma) &&
                    td.getProfessor().equals(professor)) {
                return td;
            }
        }
        return null;
    }

    @Override
    public void atualizar(TurmaDisciplina antiga, TurmaDisciplina nova) {
        for (int i = 0; i < turmaDisciplinas.length; i++) {
            if (turmaDisciplinas[i] != null && turmaDisciplinas[i].equals(antiga)) {
                turmaDisciplinas[i] = nova;
                return;
            }
        }
        System.out.println("TurmaDisciplina não encontrada para atualizar");
    }

    @Override
    public void deletar(TurmaDisciplina td) {
        for (int i = 0; i < turmaDisciplinas.length; i++) {
            if (turmaDisciplinas[i] != null && turmaDisciplinas[i].equals(td)) {
                turmaDisciplinas[i] = null;
                return;
            }
        }
        System.out.println("TurmaDisciplina não encontrada para deletar");
    }

    @Override
    public List<TurmaDisciplina> buscarTodos() {
        List<TurmaDisciplina> resultado = new ArrayList<>();
        for (TurmaDisciplina td : turmaDisciplinas) {
            if (td != null) {
                resultado.add(td);
            }
        }
        return resultado;
    }
}
