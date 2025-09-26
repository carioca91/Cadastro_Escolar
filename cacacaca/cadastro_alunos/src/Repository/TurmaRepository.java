package Repository;

import models.Pessoa;
import models.Turma;

import java.util.List;

public interface TurmaRepository {

    void cadastrar(Turma turma);
    Turma buscar(long idTurma);
    void atualizar(long idTurma, Turma turma);
    void deletar(long idTurma);
    List<Turma> buscarTodos();
}
