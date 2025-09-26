package Repository;

import models.Pessoa;

import java.util.List;

public class PessoaRepositoryVetor implements PessoaRepository {


    private Pessoa[] pessoas;

    public PessoaRepositoryVetor() {
        this.pessoas = new Pessoa[100];
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoas[i] == null){
                pessoas[i] = pessoa;
            }
        }
    }

    @Override
    public Pessoa buscar(String id) {
        Pessoa aux = null;
        for (int i = 0; i < pessoas.length ; i++) {
            if(pessoas[i].getCpf().equals(id)){
                aux = pessoas[i];
            }
        }
        return aux;
    }

    @Override
    public void atualizar(String id, Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getCpf().equals(id)){
                pessoas[i] = pessoa;
                return;
            }
        }
        System.out.println("Pessoa não encontrada.");
    }

    @Override
    public void deletar(String id) {

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getCpf().equals(id)){
                pessoas[i] = null;
                return;
            }
        }
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return List.of(pessoas);
    }
}
