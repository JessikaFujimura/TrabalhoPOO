package Boundary;

import Controller.NotasEFaltasController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class NotasEFaltasBoundary implements PatternStrategy {

    private NotasEFaltasController notasEFaltasController = new NotasEFaltasController();
    private Label Disciplina = new Label("");
    private Label NomeDoAluno = new Label("");

    @Override
    public Pane gerarTela() {
        return null;
    }

    @Override
    public Pane gerarTelaAdmin() {
        Stage stage = new Stage();
        GridPane notasFaltasBoundary = new GridPane();

        Scene scene = new Scene(notasFaltasBoundary, 500, 500);

        notasFaltasBoundary.setHgap(30);
        notasFaltasBoundary.setVgap(20);
        Label TituloNotasFaltas = new Label("NOTAS E FALTAS");
        TituloNotasFaltas.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        TituloNotasFaltas.setTextAlignment(TextAlignment.CENTER);

        Label TituloNomeDoAluno = new Label("NOME DO ALUNO");

        Label TituloSerie = new Label("SÉRIE");
        Label Serie = new Label("3º");
        Label Turma = new Label("Turma");

        Label Bimestre1 = new Label("1 Bimestre");
        TextField Bimestre1Field = new TextField();
        Bimestre1Field.setPrefSize(100,40);

        Label Bimestre2 = new Label("2 Bimestre");
        TextField Bimestre2Field = new TextField();
        Bimestre1Field.setPrefSize(100,40);

        Label Bimestre3 = new Label("3 Bimestre");
        TextField Bimestre3Field = new TextField();
        Bimestre1Field.setPrefSize(100,40);

        Label Bimestre4 = new Label("4 Bimestre");
        TextField Bimestre4Field = new TextField();
        Bimestre1Field.setPrefSize(100,40);

        Label Faltas = new Label("1 Bimestre");
        TextField faltasField = new TextField();
        Bimestre1Field.setPrefSize(100,40);

        Button Cancelar = new Button("Cancelar");
        Button Salvar = new Button("Salvar");

        notasFaltasBoundary.add(TituloNotasFaltas,1,1);
        notasFaltasBoundary.add(Disciplina,2,1);
        notasFaltasBoundary.add(TituloNomeDoAluno,1,2);
        notasFaltasBoundary.add(NomeDoAluno,2,2);
        notasFaltasBoundary.add(TituloSerie,1,3);
        notasFaltasBoundary.add(Serie,2,3);
        notasFaltasBoundary.add(Turma,3,3);
        notasFaltasBoundary.add(Bimestre1,1,7);
        notasFaltasBoundary.add(Bimestre1Field,2,7);
        notasFaltasBoundary.add(Bimestre2, 1,8);
        notasFaltasBoundary.add(Bimestre2Field,2,8);
        notasFaltasBoundary.add(Bimestre3,1,10);
        notasFaltasBoundary.add(Bimestre3Field, 2,10);
        notasFaltasBoundary.add(Bimestre4, 1,11);
        notasFaltasBoundary.add(Bimestre4Field,2,11);
        notasFaltasBoundary.add(Faltas,1,12);
        notasFaltasBoundary.add(faltasField,2,12);
        notasFaltasBoundary.add(Cancelar, 1,14);
        notasFaltasBoundary.add(Salvar,5,14);

        Salvar.setOnAction((event -> {
            notasEFaltasController.Salvar();
        }));
/*
        Bindings.bindBidirectional(Bimestre1Field.textProperty(), notasEFaltasController.bimestre1PropProperty());
        Bindings.bindBidirectional(Bimestre2Field.textProperty(), notasEFaltasController.bimestre2PropProperty());
        Bindings.bindBidirectional(Bimestre3Field.textProperty(), notasEFaltasController.bimestre3PropProperty());
        Bindings.bindBidirectional(Bimestre4Field.textProperty(), notasEFaltasController.bimestre4PropProperty());
        Bindings.bindBidirectional(Faltas.textProperty(), notasEFaltasController.faltasProperty());*/

        Cancelar.setOnAction((event -> {
            stage.close();
        }));
        stage.setScene(scene);
        stage.show();

        return notasFaltasBoundary;
    }


    public void setDisciplina(Label disciplina) {
        Disciplina = disciplina;
    }

    public void setNomeDoAluno(String nomeDoAluno) {
        NomeDoAluno.setText(nomeDoAluno);
    }
}
