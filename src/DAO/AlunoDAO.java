package DAO;

import Entity.Aluno;

import java.util.List;

public interface AlunoDAO {

    void adicionar(Aluno aluno);

    List<Aluno> pesquisar(int idMateria);

    void apagarPorId(Long id);

    void atualizar(Long id, Aluno aluno);
}
