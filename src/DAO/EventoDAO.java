package DAO;

import Entity.Evento;
import java.util.List;

public interface EventoDAO {

    void adicionar(Evento e);

    List<Evento> pesquisar(String titulo);

    void apagarPorId(Long id);

    void atualizar(Long id, Evento e);
}
