package Services;

import Repository.DisciplinaRepository;
import Repository.DisciplinaRepositoryList;
import models.Disciplina;

import java.util.List;

public class DisciplinaService {

    private DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepositoryList disciplinaRepositoryList) {
        this.repository = disciplinaRepositoryList;
    }


    public void cadastrar(Disciplina disciplina) {
        Disciplina aux = repository.buscar(disciplina.getCodDisciplina());
        if (aux != null) {
            System.out.println("A disciplina já está cadastrada.");
        } else {
            repository.cadastrar(disciplina);
            System.out.println("Disciplina foi cadastrada!");
        }
    }


    public Disciplina buscar(long codDisciplina) {
        Disciplina disciplina = repository.buscar(codDisciplina);
        if (disciplina == null) {
            System.out.println("A disciplina não foi encontrada.");
        } else {
            System.out.println("Disciplina encontrada: " + disciplina.getNomeDisciplina());
        }
        return disciplina;
    }


    public List<Disciplina> buscarTodos() {
        return repository.buscarTodos();
    }


    public void atualizar(long codDisciplina, Disciplina disciplina) {
        Disciplina existente = repository.buscar(codDisciplina);
        if (existente != null) {
            repository.atualizar(codDisciplina, disciplina);
            System.out.println("Disciplina atualizada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }


    public void deletar(long codDisciplina) {
        Disciplina disciplina = repository.buscar(codDisciplina);
        if (disciplina != null) {
            repository.deletar(codDisciplina);
            System.out.println("Disciplina deletada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada: " + codDisciplina);
        }
    }
}