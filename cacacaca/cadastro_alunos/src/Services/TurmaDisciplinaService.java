package Services;

import Repository.TurmaDisciplinaRepository;
import Repository.TurmaDisciplinaRepositoryList;
import models.Disciplina;
import models.Turma;
import models.TurmaDisciplina;
import models.Professor;

import java.util.List;

public class TurmaDisciplinaService {

    private TurmaDisciplinaRepository repository;

    public TurmaDisciplinaService(TurmaDisciplinaRepositoryList turmaDisciplinaRepositoryList) {
        this.repository = turmaDisciplinaRepositoryList;
    }


    public void cadastrar(TurmaDisciplina turmaDisciplina) {
        TurmaDisciplina aux = repository.buscar(
                turmaDisciplina.getDisciplina(),
                turmaDisciplina.getTurma(),
                turmaDisciplina.getProfessor()
        );
        if (aux != null) {
            System.out.println("A turma disciplina já está cadastrada.");
        } else {
            repository.cadastrar(turmaDisciplina);
            System.out.println("Turma disciplina cadastrada com sucesso!");
        }
    }


    public TurmaDisciplina buscar(Disciplina disciplina, Turma turma, Professor professor) {
        TurmaDisciplina turmaDisciplina = repository.buscar(disciplina, turma, professor);
        if (turmaDisciplina == null) {
            System.out.println("A turma disciplina não foi encontrada.");
        } else {
            System.out.println("Turma disciplina encontrada: " +
                    turmaDisciplina.getDisciplina().getNomeDisciplina());
        }
        return turmaDisciplina;
    }


    public List<TurmaDisciplina> buscarTodos() {
        return repository.buscarTodos();
    }


    public void atualizar(Disciplina disciplina, Turma turma, Professor professor, TurmaDisciplina novaTurmaDisciplina) {
        TurmaDisciplina existente = repository.buscar(disciplina, turma, professor);
        if (existente != null) {
            repository.atualizar(existente, novaTurmaDisciplina);
            System.out.println("Turma disciplina atualizada com sucesso!");
        } else {
            System.out.println("Turma disciplina não encontrada.");
        }
    }


    public void deletar(Disciplina disciplina, Turma turma, Professor professor) {
        TurmaDisciplina turmaDisciplina = repository.buscar(disciplina, turma, professor);
        if (turmaDisciplina != null) {
            repository.deletar(turmaDisciplina);
            System.out.println("Turma disciplina deletada com sucesso!");
        } else {
            System.out.println("Turma disciplina não encontrada.");
        }
    }
}