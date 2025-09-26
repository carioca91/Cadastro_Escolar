package Repository;

import models.Disciplina;
import models.Professor;
import models.Turma;
import models.TurmaDisciplina;

import java.util.List;

public interface TurmaDisciplinaRepository {

    void cadastrar(TurmaDisciplina turmaDisciplina);
    TurmaDisciplina buscar(Disciplina disciplina, Turma turma, Professor professor);
    void atualizar(TurmaDisciplina antiga, TurmaDisciplina nova);
    void deletar(TurmaDisciplina td);
    List<TurmaDisciplina> buscarTodos();
}
