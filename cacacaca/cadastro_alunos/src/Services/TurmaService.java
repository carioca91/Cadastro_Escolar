package Services;

import Repository.TurmaRepository;
import Repository.TurmaRepositoryList;
import models.Turma;

import java.util.List;

public class TurmaService {

    private TurmaRepository repository;

    public TurmaService(TurmaRepositoryList turmaRepositoryList) {
        this.repository = turmaRepositoryList;
    }


    public void cadastrar(Turma turma) {
        Turma aux = repository.buscar(turma.getIdTurma());
        if (aux != null) {
            System.out.println("A turma já está cadastrada.");
        } else {
            repository.cadastrar(turma);
            System.out.println("Turma cadastrada com sucesso!");
        }
    }


    public Turma buscar(long idTurma) {
        Turma turma = repository.buscar(idTurma);
        if (turma == null) {
            System.out.println("Turma não encontrada.");
        } else {
            System.out.println("Turma encontrada: " + turmaToString(turma));
        }
        return turma;
    }


    public List<Turma> buscarTodos() {
        return repository.buscarTodos();
    }


    public void atualizar(long idTurma, Turma turma) {
        Turma existente = repository.buscar(idTurma);
        if (existente != null) {
            repository.atualizar(idTurma, turma);
            System.out.println("Turma atualizada com sucesso!");
        } else {
            System.out.println("Turma não foi encontrada.");
        }
    }


    public void deletar(long idTurma) {
        Turma turma = repository.buscar(idTurma);
        if (turma != null) {
            repository.deletar(idTurma);
            System.out.println("Turma deletada com sucesso!");
        } else {
            System.out.println("Turma não encontrada: " + idTurma);
        }
    }

    private String turmaToString(Turma turma) {
        return "ID: " + turma.getIdTurma() + ", Semestre: " + turma.getSemestre();
    }
}