package Repository;

import models.Disciplina;

import java.util.List;

public class DisciplinaRepositoryVetor implements DisciplinaRepository{

    private Disciplina[] disciplinas;

    public DisciplinaRepositoryVetor(){
        this.disciplinas = new Disciplina[100];

    }

    @Override
    public void cadastrar(Disciplina disciplina) {
        for (int i = 0; i < disciplinas.length; i++) {
            if(disciplinas[i] == null){
                disciplinas[i] = disciplina;
            }
        }
    }

    @Override
    public Disciplina buscar(long codDisciplina) {
        Disciplina aux = null;
        for (int i = 0; i < disciplinas.length; i++) {
            if(disciplinas[i].getCodDisciplina() == (codDisciplina)){
                aux = disciplinas[i];
            }
        }
        return aux;
    }

    @Override
    public void atualizar(long codDisciplina, Disciplina disciplina) {

    }

    @Override
    public void deletar(long codDisciplina) {
        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i].getCodDisciplina() == (codDisciplina)) {
                disciplinas[i] = null;
                return;
            }
        }
    }

    @Override
    public List<Disciplina> buscarTodos() {
        return List.of(disciplinas);
    }
}
