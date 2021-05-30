package Boundary;

import Controller.EventoController;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class EventoBoundary {

    private GridPane eventBoundary;
    private TextField tituloEvento = new TextField();
    private DatePicker dataEvento = new DatePicker();
    private TextField horaEvento = new TextField("00:00");

    private Button criarEvento = new Button("Criar");
    private Button cancelar= new Button("Cancelar");

    private EventoController eventoController = new EventoController();


    public EventoBoundary() {
        eventBoundary = new GridPane();

        Text textoPrincipal = new Text("Criar novo evento");
        textoPrincipal.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        textoPrincipal.setTextAlignment(TextAlignment.CENTER);
        textoPrincipal.setFill(Color.BLUEVIOLET);

        eventBoundary.setHgap(30);
        eventBoundary.setVgap(20);

        eventBoundary.setMinSize(600,400);

        eventBoundary.add(textoPrincipal, 1,1,2,1);
        eventBoundary.add(new Label("Titulo:"), 1,2);
        eventBoundary.add(tituloEvento, 2, 2);
        eventBoundary.add(new Label("Data:"), 1,3);
        eventBoundary.add(dataEvento, 2,3);
        eventBoundary.add(new Label("Hora:"), 1,4);
        eventBoundary.add(horaEvento, 2,4);
        eventBoundary.add(criarEvento, 2,5);
        eventBoundary.add(cancelar, 1,5);

        criarEvento.setPrefSize(100,40);
        cancelar.setPrefSize(100, 40);
        criarEvento.setTextFill(Color.GREEN);


        criarEvento.setOnAction((event -> {
            eventoController.adicionar();
        }));

        eventBoundary.setAlignment(Pos.CENTER);

        Bindings.bindBidirectional(tituloEvento.textProperty(), eventoController.tituloPropProperty());
        Bindings.bindBidirectional(dataEvento.valueProperty(), eventoController.dataPropProperty());
        Bindings.bindBidirectional(horaEvento.textProperty(), eventoController.horaPropProperty());

/*        cancelar.setOnAction(event -> {
            stage.close();
        });*/

    }

    public GridPane getEventBoundary() {
        return eventBoundary;
    }
}
