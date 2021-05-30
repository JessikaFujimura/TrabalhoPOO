package Boundary;

import Controller.EventoController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class EventoBoundary extends Application {

    private TextField tituloEvento = new TextField();
    private DatePicker dataEvento = new DatePicker();
    private TextField horaEvento = new TextField("00:00");

    private Button criarEvento = new Button("Criar");
    private Button cancelar= new Button("Cancelar");

    private EventoController eventoController = new EventoController();

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        Scene sc = new Scene(grid, 300, 250);

        grid.add(new Label(""), 2,1);
        grid.add(new Label("Criar novo evento"), 2,2);
        grid.add(new Label(""), 2,3);
        grid.add(new Label("Titulo:"), 2,4);
        grid.add(tituloEvento, 3, 4);
        grid.add(new Label(""), 2,5);
        grid.add(new Label("Data:"), 2,6);
        grid.add(dataEvento, 3,6);
        grid.add(new Label(""), 2,7);
        grid.add(new Label("Hora:"), 2,8);
        grid.add(horaEvento, 3,8);
        grid.add(new Label(""), 2,9);
        grid.add(criarEvento, 3,10);
        grid.add(cancelar, 2,10);

        criarEvento.setOnAction((event -> {
            eventoController.adicionar();
        }));


        Bindings.bindBidirectional(tituloEvento.textProperty(), eventoController.tituloPropProperty());
        Bindings.bindBidirectional(dataEvento.valueProperty(), eventoController.dataPropProperty());
        Bindings.bindBidirectional(horaEvento.textProperty(), eventoController.horaPropProperty());

        cancelar.setOnAction(event -> {
            stage.close();
        });

        stage.setTitle("Criar novo evento");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(EventoBoundary.class, args);
    }

}
