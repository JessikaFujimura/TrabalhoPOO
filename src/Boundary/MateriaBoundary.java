package Boundary;

import Controller.MateriaController;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MateriaBoundary extends Application {

    private TextField idMateria = new TextField();
    private Button buscarMateria = new Button("Buscar");

    private MateriaController materiaController = new MateriaController();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        BorderPane principal = new BorderPane();
        Scene sc = new Scene(principal, 400,300);

        grid.add(new Label("BUSCAR MATÉRIA"), 2,1);
        grid.add(new Label("Código: "), 1,3);
        grid.add(idMateria, 2, 3);
        grid.add(buscarMateria, 3, 3);

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
