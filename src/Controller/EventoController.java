package Controller;

import Entity.Evento;
import javafx.beans.property.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoController {

    private static Long id = 0L;
    private StringProperty tituloProp = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> dataProp = new SimpleObjectProperty<>();
    private StringProperty horaProp = new SimpleStringProperty("00:00");

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private List<Evento> eventos = new ArrayList<>();

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
        Evento evento = getEntity();
        eventos.add(evento);
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String insert = "INSERT INTO eventos (titulo,data,hora) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insert);
            preparedStatement.setString(1, tituloProp.get());
            preparedStatement.setDate(2, java.sql.Date.valueOf(dataProp.get()));
            preparedStatement.setString(3, horaProp.get());
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pesquisar(){ //Esse método vai ser usado em outra boundary, na boundary da home.
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String select = "SELECT * FROM eventos";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Long id = result.getLong("ID");
                String titulo = result.getString("TITULO");
                LocalDate data = result.getDate("DATA").toLocalDate();
                String hora = result.getString("HORA");
                Evento evento = new Evento();
                evento.setId(id);
                evento.setTitulo(titulo);
                evento.setData(data);
                evento.setHora(hora);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Evento ev: eventos) {
            if (ev.getTitulo().contains(getTituloProp())) {
                setEntity(ev);
            }
        }
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
