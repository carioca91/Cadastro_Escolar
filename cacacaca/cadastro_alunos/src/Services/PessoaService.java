package Services;

import Repository.PessoaRepository;
import Repository.PessoaRepositoryList;
import models.Pessoa;

import java.util.List;

public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepositoryList pessoaRepositoryList) {
        this.repository = pessoaRepositoryList;
    }


    public void cadastrar(Pessoa pessoa) {
        Pessoa aux = repository.buscar(pessoa.getCpf());
        if (aux != null) {
            System.out.println("A pessoa já está cadastrada.");
        } else {
            repository.cadastrar(pessoa);
            System.out.println("Pessoa foi cadastrada!");
        }
    }


    public Pessoa buscar(String cpf) {
        Pessoa pessoa = repository.buscar(cpf);
        if (pessoa == null) {
            System.out.println("A pessoa não foi encontrada.");
        } else {
            System.out.println("Pessoa encontrada: " + pessoa.toString());
        }
        return pessoa;
    }


    public List<Pessoa> buscarTodos() {
        return repository.buscarTodos();
    }


    public void atualizar(String cpf, Pessoa pessoa) {
        Pessoa existente = repository.buscar(cpf);
        if (existente != null) {
            repository.atualizar(cpf, pessoa);
            System.out.println("Pessoa atualizada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    public void deletar(String cpf) {
        Pessoa pessoa = repository.buscar(cpf);
        if (pessoa != null) {
            repository.deletar(cpf);
            System.out.println("Pessoa deletada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada: " + cpf);
        }
    }
}