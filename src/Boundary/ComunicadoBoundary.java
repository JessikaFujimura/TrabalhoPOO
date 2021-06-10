package Boundary;

import Controller.ComunicadoController;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ComunicadoBoundary {
    private ComunicadoController comunicadoController= new ComunicadoController();

    public void gerarTelaAdmin() {
        Stage stage = new Stage();
        GridPane comBoundary = new GridPane();
        Scene scene = new Scene(comBoundary, 800, 400);
        TextField tituloComun = new TextField();
        TextArea descricaoComun = new TextArea("");

        Button criarComunicado = new Button("Criar");
        Button cancelar= new Button("Cancelar");

        Text textoPrincipal = new Text("Criar novo comunicado");
        textoPrincipal.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        textoPrincipal.setTextAlignment(TextAlignment.CENTER);
        textoPrincipal.setFill(Color.BLUEVIOLET);

        comBoundary.setHgap(30);
        comBoundary.setVgap(20);

        comBoundary.setMinSize(500,400);

        comBoundary.add(textoPrincipal, 1,1,2,1);
        comBoundary.add(new Label("Titulo:"), 1,2);
        comBoundary.add(tituloComun, 2, 2);
        comBoundary.add(new Label("Descrição:"), 1,3);
        comBoundary.add(descricaoComun, 2,3);
        comBoundary.add(criarComunicado, 2,5);
        comBoundary.add(cancelar, 1,5);

        criarComunicado.setPrefSize(100,40);
        cancelar.setPrefSize(100, 40);
        criarComunicado.setTextFill(Color.GREEN);


        criarComunicado.setOnAction((event -> {
           comunicadoController.adicionar();
        }));

        comBoundary.setAlignment(Pos.CENTER);

        Bindings.bindBidirectional(tituloComun.textProperty(), comunicadoController.tituloPropProperty());
        Bindings.bindBidirectional(descricaoComun.textProperty(), comunicadoController.descricaoPropProperty());

        cancelar.setOnAction(event -> {
            stage.close();
        });

        stage.setScene(scene);
        stage.show();

    }
}
