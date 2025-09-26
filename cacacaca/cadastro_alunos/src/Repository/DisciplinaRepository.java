package Repository;

import models.Disciplina;
import models.Pessoa;

import java.util.List;

public interface DisciplinaRepository {

    void cadastrar(Disciplina disciplina);
    Disciplina buscar(long codDisciplina);
    void atualizar(long codDisciplina, Disciplina disciplina);
    void deletar(long codDisciplina);
    List<Disciplina> buscarTodos();
}
