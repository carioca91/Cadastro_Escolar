package Repository;

import models.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepositoryList implements DisciplinaRepository{
    private List<Disciplina> disciplinas;

    public DisciplinaRepositoryList(){
        this.disciplinas = new ArrayList<>();
    }


    @Override
    public void cadastrar(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    @Override
    public Disciplina buscar(long codDisciplina) {
        Disciplina disciplina = null;
        for (int i = 0; i < disciplinas.size(); i++) {
            if(disciplinas.get(i).equals(codDisciplina)){
                disciplina = disciplinas.get(i);
            }
        }
        return disciplina;
    }

    @Override
    public void atualizar(long codDisciplina, Disciplina disciplina) {

    }

    @Override
    public void deletar(long codDisciplina) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).equals(codDisciplina)){
                disciplinas.remove(i);
            }

        }
    }

    @Override
    public List<Disciplina> buscarTodos() {
        return disciplinas;
    }
}
