package Repository;

import models.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaRepositoryList implements TurmaRepository{
    private List<Turma> turmas;

    public TurmaRepositoryList(){
        this.turmas = new ArrayList<>();
    }

    @Override
    public void cadastrar(Turma turma) {
        this.turmas.add(turma);
    }

    @Override
    public Turma buscar(long idTurma) {
        Turma turma = null;
        for (int i = 0; i < turmas.size(); i++) {
            if(turmas.get(i).equals(idTurma)){
                turma = turmas.get(i);
            }
        }
        return turma;
    }

    @Override
    public void atualizar(long idTurma, Turma turma) {

    }

    @Override
    public void deletar(long idTurma) {
        for (int i = 0; i < turmas.size(); i++) {
            if(turmas.get(i).equals(idTurma)){
                turmas.remove(i);
            }
        }
    }

    @Override
    public List<Turma> buscarTodos() {
        return turmas;
    }
}
