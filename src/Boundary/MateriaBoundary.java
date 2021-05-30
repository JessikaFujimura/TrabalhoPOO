package Boundary;

import Controller.AlunoController;
import Controller.MateriaController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class MateriaBoundary extends Application {

    private TextField codMateria = new TextField();
    private Button buscarMateria = new Button("Buscar");

    private MateriaController materiaController = new MateriaController();
    private AlunoController alunoController = new AlunoController();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        BorderPane principal = new BorderPane();
        Scene sc = new Scene(principal, 400,300);

        grid.add(new Label("BUSCAR MATÉRIA"), 2,1);
        grid.add(new Label("Código: "), 1,3);
        grid.add(codMateria, 2, 3);
        grid.add(buscarMateria, 3, 3);

        buscarMateria.setOnAction((event -> {
            materiaController.getTable().getItems().clear();
            materiaController.pesquisar();
        }));

        StringConverter longToString = new LongStringConverter();

        Bindings.bindBidirectional(codMateria.textProperty(),
                materiaController.codPropProperty(),
                longToString);

        materiaController.generatedTable();
        principal.setTop(grid);
        principal.setCenter(materiaController.getTable());

        stage.setScene(sc);
        stage.setTitle("Notas e faltas");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(MateriaBoundary.class, args);
    }
}
