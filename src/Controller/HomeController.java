package Controller;

import Entity.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public Evento gerarEvento(){
        Evento t = new Evento();
        t.setId(1l);
        t.setTitulo("Teste");
        t.setData(LocalDate.now());
        t.setHora("12:00");
        return t;
    }
    @FXML
    TableView<Evento> tableID = new TableView<>();
    @FXML
    TableColumn<Evento, String> titulo;
    @FXML
    TableColumn<Evento, LocalDate> data;
    @FXML
    TableColumn<Evento, String> hora;

    ObservableList<Evento> dados =
            FXCollections.observableArrayList(gerarEvento());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titulo.setCellValueFactory(new PropertyValueFactory<Evento, String>("titulo"));
        data.setCellValueFactory(new PropertyValueFactory<Evento, LocalDate>("data"));
        hora.setCellValueFactory(new PropertyValueFactory<Evento, String>("hora"));
        tableID.setItems(dados);
    }
}
