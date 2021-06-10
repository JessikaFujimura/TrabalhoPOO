package Boundary;

import Controller.AlunoController;
import Controller.MateriaController;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.StringConverter;
import javafx.util.converter.LongStringConverter;

public class MateriaBoundary implements PatternStrategy {

    private BorderPane materiaBoundary = new BorderPane();
    private MateriaController materiaController = new MateriaController();
    private AlunoController alunoController = new AlunoController();

    @Override
    public Pane gerarTela() {
        GridPane grid = new GridPane();

        grid.setPrefSize(800, 200);

        Text textoPrincipal = new Text("NOTAS E FALTAS");
        textoPrincipal.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        textoPrincipal.setTextAlignment(TextAlignment.CENTER);
        textoPrincipal.setFill(Color.BLUEVIOLET);

        grid.setHgap(30);
        grid.setVgap(20);

        grid.add(textoPrincipal, 1,1, 2, 1);

        grid.setAlignment(Pos.TOP_LEFT);

        alunoController.generatedTable();
        materiaBoundary.setTop(grid);
        materiaBoundary.setCenter(alunoController.getTable());

        return materiaBoundary;
    }

    @Override
    public Pane gerarTelaAdmin() {
        GridPane grid = new GridPane();

        grid.setPrefSize(800, 200);

        TextField codMateria = new TextField("");
        Button buscarMateria = new Button("Buscar");

        Text textoPrincipal = new Text("LANÇAR NOTAS E FALTAS");
        textoPrincipal.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        textoPrincipal.setTextAlignment(TextAlignment.CENTER);
        textoPrincipal.setFill(Color.BLUEVIOLET);

        grid.setHgap(30);
        grid.setVgap(20);

        grid.add(textoPrincipal, 1,1, 2, 1);
        grid.add(new Label("Código da matéria: "), 1,3);
        grid.add(codMateria, 2, 3);
        grid.add(buscarMateria, 3, 3);

        grid.setAlignment(Pos.TOP_LEFT);

        FlowPane fp = new FlowPane();

        MenuBar menu = new MenuBar();
        Menu m = new Menu("Menu");
        MenuItem home = new MenuItem("Home");
        menu.getMenus().addAll(m);
        m.getItems().addAll(home);

        fp.getChildren().addAll(menu);

        materiaBoundary.setTop(fp);

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

        return materiaBoundary;
    }
}
