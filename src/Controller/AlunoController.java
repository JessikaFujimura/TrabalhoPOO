package Controller;

import Entity.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoController {

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();
    private TableView<Aluno> table = new TableView<>();


    public void adicionar(Aluno aluno) {
        this.alunos.add(aluno);
    }

        public void generatedTable(){
        TableColumn<Aluno, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<Aluno, Long>("idAluno"));

        TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));

        TableColumn<Aluno, Double> col1Bim = new TableColumn<>("1 Bimestre");
        col1Bim.setCellValueFactory(new PropertyValueFactory<>("n1"));

        TableColumn<Aluno, Double> col2Bim = new TableColumn<>("2 Bimestre");
        col2Bim.setCellValueFactory(new PropertyValueFactory<>("n1"));

        TableColumn<Aluno, Double> col3Bim = new TableColumn<>("3 Bimestre");
        col3Bim.setCellValueFactory(new PropertyValueFactory<>("n3"));

        TableColumn<Aluno, Double> col4Bim = new TableColumn<>("4 Bimestre");
        col4Bim.setCellValueFactory(new PropertyValueFactory<>("n4"));

        TableColumn<Aluno, Integer> faltas = new TableColumn<>("Faltas");
        col4Bim.setCellValueFactory(new PropertyValueFactory<>("faltas"));

        table.getColumns().addAll(colId, colNome, col1Bim, col2Bim, col3Bim, col4Bim, faltas);

        table.setItems(alunos);
    }

    public TableView<Aluno> getTable() {
        return table;
    }
}
