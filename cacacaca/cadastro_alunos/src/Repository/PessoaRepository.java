package Repository;

import models.Pessoa;

import java.util.List;

public interface PessoaRepository{

    void cadastrar(Pessoa pessoa);
    Pessoa buscar(String id);
    void atualizar(String id, Pessoa pessoa);
    void deletar(String id);
    List<Pessoa> buscarTodos();

}
