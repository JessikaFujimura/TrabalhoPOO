package Controller;

import Entity.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;


public class AlunoController {

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static ObservableList<Aluno> alunos = FXCollections.observableArrayList();
    private static TableView<Aluno> table = new TableView<>();


    public void buscarAlunosPorMateria(Integer idMateria){
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String select = "SELECT * FROM ALUNOS WHERE IDALUNO = ANY (SELECT IDALUNO FROM ALUNOSMAT WHERE IDMATERIA=?)";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setInt(1, idMateria);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Long id = result.getLong("IDALUNO");
                String nome = result.getString("NOMEALUNO");
                Double n1 = result.getDouble("N1");
                Double n2 = result.getDouble("N2");
                Double n3 = result.getDouble("N3");
                Double n4 = result.getDouble("N4");
                Integer faltas = result.getInt("FALTA");

                Aluno aluno = new Aluno();
                aluno.setIdAluno(id);
                aluno.setNome(nome);
                aluno.setN1(n1);
                aluno.setN2(n2);
                aluno.setN3(n3);
                aluno.setN4(n4);
                aluno.setFaltas(faltas);
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generatedTable(){

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
        faltas.setCellValueFactory(new PropertyValueFactory<>("faltas"));

        table.getColumns().addAll(colId, colNome, col1Bim, col2Bim, col3Bim, col4Bim, faltas );

        table.setItems(alunos);

    }

    public TableView<Aluno> getTable() {
        return table;
    }

}