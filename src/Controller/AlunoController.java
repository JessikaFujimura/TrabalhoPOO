package Controller;

import DAO.AlunoDAOImpl;
import Entity.Aluno;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

import java.util.List;


public class AlunoController {


    private static ObservableList<Aluno> alunos = FXCollections.observableArrayList();
    private static TableView<Aluno> table = new TableView<>();

    private AlunoDAOImpl alunoDAO = new AlunoDAOImpl();

    public void buscarAlunosPorMateria(Integer idMateria){
       List<Aluno> lista = alunoDAO.pesquisar(idMateria);
       alunos.addAll(lista);
    }

    public static void generatedTable(){

        TableColumn<Aluno, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<Aluno, Long>("idAluno"));

        TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
        colNome.setMinWidth(100);

        TableColumn<Aluno, Double> col1Bim = new TableColumn<>("1 Bimestre");
        col1Bim.setCellValueFactory(new PropertyValueFactory<>("n1"));
        col1Bim.setMinWidth(100);

        TableColumn<Aluno, Double> col2Bim = new TableColumn<>("2 Bimestre");
        col2Bim.setCellValueFactory(new PropertyValueFactory<>("n1"));
        col2Bim.setMinWidth(100);

        TableColumn<Aluno, Double> col3Bim = new TableColumn<>("3 Bimestre");
        col3Bim.setCellValueFactory(new PropertyValueFactory<>("n3"));
        col3Bim.setMinWidth(100);

        TableColumn<Aluno, Double> col4Bim = new TableColumn<>("4 Bimestre");
        col4Bim.setCellValueFactory(new PropertyValueFactory<>("n4"));
        col4Bim.setMinWidth(100);

        TableColumn<Aluno, Integer> faltas = new TableColumn<>("Faltas");
        faltas.setCellValueFactory(new PropertyValueFactory<>("faltas"));

        TableColumn<Aluno, String> botoes = new TableColumn<>("");
        botoes.setMinWidth(200);

        Callback<TableColumn<Aluno, String>, TableCell<Aluno, String>> cell = new Callback<TableColumn<Aluno, String>, TableCell<Aluno, String>>() {
            @Override
            public TableCell<Aluno, String> call(TableColumn<Aluno, String> param) {
                return new TableCell<Aluno, String>(){
                    public void updateItem(String item, boolean vazio){
                        super.updateItem(item, vazio);
                        if (vazio){
                            setGraphic(null);
                            setText(null);
                        } else {
                            FlowPane flow = new FlowPane();
                            Button btnEditar = new Button("editar");
                            Button btnApagar = new Button("Apagar");
                            flow.getChildren().addAll(btnEditar, btnApagar);

                            btnEditar.setOnAction(event -> {
                                System.out.println("Editar");
                            });
                            setGraphic(flow);
                            setText(null);
                        }

                    }
                };
            }
        };

        botoes.setCellFactory(cell);

        table.getColumns().addAll(colId, colNome, col1Bim, col2Bim, col3Bim, col4Bim, faltas, botoes);

        table.setItems(alunos);

    }

    public TableView<Aluno> getTable() {
        return table;
    }

}
