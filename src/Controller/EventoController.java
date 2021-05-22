package Controller;

import Entity.Evento;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventoController {

    private static Long id = 0L;
    private LongProperty idProp = new SimpleLongProperty(0);
    private StringProperty tituloProp = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataProp = new SimpleObjectProperty<>();
    private StringProperty horaProp = new SimpleStringProperty("00:00");

    private List<Evento> eventos = new ArrayList<>();

    private void setEntity(Evento evento){
        if(evento != null){
         idProp.set(evento.getId());
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
        Evento evento = getEntity();
        System.out.println(evento);
        eventos.add(evento);
    }

    public void pesquisar(){ //Esse método vai ser usado em outra boundary, na boundary da home.
        for(Evento ev: eventos) {
            if (ev.getTitulo().contains(getTituloProp())) {
                setEntity(ev);
            }
        }
    }

    public long getIdProp() {
        return idProp.get();
    }

    public LongProperty idPropProperty() {
        return idProp;
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
