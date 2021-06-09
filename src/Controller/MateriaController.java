package Controller;

import Entity.Aluno;
import Entity.Materia;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

public class MateriaController {

    private static Long id;
    private LongProperty codProp = new SimpleLongProperty();
    private StringProperty nomeProp = new SimpleStringProperty();
    private ObjectProperty<Aluno> notasProp = new SimpleObjectProperty<>();
    private IntegerProperty faltaProp = new SimpleIntegerProperty();

    private static ObservableList<Materia> materias = FXCollections.observableArrayList();
    private static TableView<Materia> table = new TableView<>();

    private AlunoController alunoController = new AlunoController();

    public void pesquisar(){
        alunoController.buscarAlunosPorMateria((int) codProp.get());
    }

    public void generatedTable(){

        TableColumn<Materia, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Materia, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
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


        table.getColumns().addAll(colId, colNome);

        table.setItems(materias);

    }


    public long getCodProp() {
        return codProp.get();
    }

    public LongProperty codPropProperty() {
        return codProp;
    }

    public void setCodProp(long codProp) {
        this.codProp.set(codProp);
    }

    public void setCodProp(int codProp) {
        this.codProp.set(codProp);
    }

    public String getNomeProp() {
        return nomeProp.get();
    }

    public StringProperty nomePropProperty() {
        return nomeProp;
    }

    public void setNomeProp(String nomeProp) {
        this.nomeProp.set(nomeProp);
    }

    public int getFaltaProp() {
        return faltaProp.get();
    }

    public IntegerProperty faltaPropProperty() {
        return faltaProp;
    }

    public void setFaltaProp(int faltaProp) {
        this.faltaProp.set(faltaProp);
    }


}
