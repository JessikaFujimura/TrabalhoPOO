package DAO;

import Entity.Comunicado;

import java.util.List;

public interface ComunicadoDAO {

    void adicionar(Comunicado com);

    List<Comunicado> pesquisar(String titulo);

    void apagarPorId(Long id);

    void atualizar(Long id, Comunicado com);
}
