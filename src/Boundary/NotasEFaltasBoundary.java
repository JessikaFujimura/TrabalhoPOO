package Boundary;

import Controller.NotasEFaltasController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;

public class NotasEFaltasBoundary implements PatternStrategy {

    private NotasEFaltasController notasEFaltasController = new NotasEFaltasController();

    @Override
    public Pane gerarTela() {
        return null;
    }

    @Override
    public Pane gerarTelaAdmin() {

        GridPane NotasFaltasBoundary = new GridPane();
        NotasFaltasBoundary.setHgap(30);
        NotasFaltasBoundary.setVgap(20);
        Label TituloNotasFaltas = new Label("NOTAS E FALTAS");
        TituloNotasFaltas.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        TituloNotasFaltas.setTextAlignment(TextAlignment.CENTER);
        Label Disciplina = new Label("PORTUGUÊS");
        Label TituloNomeDoAluno = new Label("NOME DO ALUNO");
        Label NomeDoAluno = new Label("JOAO SILVA");
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

        NotasFaltasBoundary.add(TituloNotasFaltas,1,1);
        NotasFaltasBoundary.add(Disciplina,2,1);
        NotasFaltasBoundary.add(TituloNomeDoAluno,1,2);
        NotasFaltasBoundary.add(NomeDoAluno,2,2);
        NotasFaltasBoundary.add(TituloSerie,1,3);
        NotasFaltasBoundary.add(Serie,2,3);
        NotasFaltasBoundary.add(Turma,3,3);
        NotasFaltasBoundary.add(Bimestre1,1,7);
        NotasFaltasBoundary.add(Bimestre1Field,2,7);
        NotasFaltasBoundary.add(Bimestre2, 1,8);
        NotasFaltasBoundary.add(Bimestre2Field,2,8);
        NotasFaltasBoundary.add(Bimestre3,1,10);
        NotasFaltasBoundary.add(Bimestre3Field, 2,10);
        NotasFaltasBoundary.add(Bimestre4, 1,11);
        NotasFaltasBoundary.add(Bimestre4Field,2,11);
        NotasFaltasBoundary.add(Faltas,1,12);
        NotasFaltasBoundary.add(faltasField,2,12);
        NotasFaltasBoundary.add(Cancelar, 1,14);
        NotasFaltasBoundary.add(Salvar,5,14);

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

        }));

        return NotasFaltasBoundary;
    }


}
