package DAO;

import Entity.Materia;

import java.util.List;

public interface MateriaDAO {

    void adicionar(Materia materia);

    List<Materia> pesquisar(String nome);

    void apagarPorId(Long id);

    void atualizar(Long id, Materia materia);
}
