package Controller;

import DAO.EventoDAOImpl;
import Entity.Evento;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.List;

public class EventoController {

    private static Long id = 0L;
    private StringProperty tituloProp = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataProp = new SimpleObjectProperty<>();
    private StringProperty horaProp = new SimpleStringProperty("00:00");

    private EventoDAOImpl eventoDAO = new EventoDAOImpl();

    private void setEntity(Evento evento){
        if(evento != null){
         tituloProp.set(evento.getTitulo());
         dataProp.set(evento.getData());
         horaProp.set(evento.getHora());
        }
    }

    private Evento getEntity(){
        Evento evento = new Evento();
        id++;
        evento.setId(id);
        evento.setTitulo(tituloProp.get());
        evento.setData(dataProp.get());
        evento.setHora(horaProp.get());
        return evento;
    }

    public void adicionar(){
        Evento ev = getEntity();
        eventoDAO.adicionar(ev);
    }

    public void pesquisar(){
        List<Evento> result = eventoDAO.pesquisar(tituloProp.get());
    }

    public void apagar(Long id){
        eventoDAO.apagarPorId(id);
    }

    public void atualizar(Long id, Evento evento){
        eventoDAO.atualizar(id, evento);
    }


    public String getTituloProp() {
        return tituloProp.get();
    }

    public StringProperty tituloPropProperty() {
        return tituloProp;
    }

    public LocalDate getDataProp() {
        return dataProp.get();
    }

    public ObjectProperty<LocalDate> dataPropProperty() {
        return dataProp;
    }

    public String getHoraProp() {
        return horaProp.get();
    }

    public StringProperty horaPropProperty() {
        return horaProp;
    }
}
