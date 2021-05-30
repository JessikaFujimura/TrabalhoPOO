package Boundary;

import Controller.AlunoController;
import Controller.MateriaController;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class MateriaBoundary {

    private BorderPane materiaBoundary;
    private TextField codMateria = new TextField("");
    private Button buscarMateria = new Button("Buscar");

    private MateriaController materiaController = new MateriaController();
    private AlunoController alunoController = new AlunoController();

    public MateriaBoundary() {
        materiaBoundary = new BorderPane();
        GridPane grid = new GridPane();

        grid.setPrefSize(800, 200);

        Text textoPrincipal = new Text("BUSCAR MATÉRIA");
        textoPrincipal.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        textoPrincipal.setTextAlignment(TextAlignment.CENTER);
        textoPrincipal.setFill(Color.BLUEVIOLET);

        grid.setHgap(30);
        grid.setVgap(20);

        grid.add(textoPrincipal, 1,1, 2, 1);
        grid.add(new Label("Código: "), 1,3);
        grid.add(codMateria, 2, 3);
        grid.add(buscarMateria, 3, 3);

        grid.setAlignment(Pos.CENTER);

        buscarMateria.setOnAction((event -> {
            alunoController.getTable().getItems().clear();
            materiaController.pesquisar();
        }));

        StringConverter longToString = new LongStringConverter();

        Bindings.bindBidirectional(codMateria.textProperty(),
                materiaController.codPropProperty(),
                longToString);

        alunoController.generatedTable();
        materiaBoundary.setTop(grid);
        materiaBoundary.setCenter(alunoController.getTable());

    }

    public BorderPane getMateriaBoundary() {
        return materiaBoundary;
    }
}
