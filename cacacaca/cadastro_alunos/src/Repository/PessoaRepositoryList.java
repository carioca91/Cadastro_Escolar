package Repository;

import models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryList implements PessoaRepository{
    private List<Pessoa> pessoas;

    public PessoaRepositoryList(){
        this.pessoas = new ArrayList<>();
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    @Override
    public Pessoa buscar(String id) {
        Pessoa pessoa = null;
        for (int i = 0; i < pessoas.size(); i++) {
            if(pessoas.get(i).getCpf().equals(id)){
                pessoa = pessoas.get(i);
            }
        }
        return pessoa;
    }

    @Override
    public void atualizar(String id, Pessoa novaPessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getCpf().equals(id)){
                pessoas.set(i, novaPessoa);
                return;
            }
        }
        System.out.println("Pessoa não encontrada.");

    }

    @Override
    public void deletar(String id) {
        for (int i = 0; i < pessoas.size(); i++) {
            if(pessoas.get(i).getCpf().equals(id))
                pessoas.remove(i);
        }
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return pessoas;
    }
}
