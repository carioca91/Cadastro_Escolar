package Repository;

import models.Turma;

import java.util.List;

public class TurmaRepositoryVetor implements TurmaRepository{

    private Turma[] turmas;

    public TurmaRepositoryVetor() {
        this.turmas = new Turma[100];
    }

    @Override
    public void cadastrar(Turma turma) {
        for (int i = 0; i < turmas.length; i++) {
            if(turmas[i] == null){
                turmas[i] =turma;
            }
        }
    }

    @Override
    public Turma buscar(long idTurma) {
        Turma aux = null;
        for (int i = 0; i < turmas.length; i++) {
            if(turmas[i].getIdTurma() == idTurma){
                aux = turmas[i];
            }
        }
        return aux;
    }

    @Override
    public void atualizar(long idTurma, Turma turma) {

    }

    @Override
    public void deletar(long idTurma) {
        for (int i = 0; i < turmas.length; i++) {
            if(turmas[i].getIdTurma() == idTurma){
                turmas[i] = null;
                return;
            }
        }
    }

    @Override
    public List<Turma> buscarTodos() {
        return List.of(turmas);
    }
}
