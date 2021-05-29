package Controller;

import Entity.Aluno;
import Entity.Materia;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MateriaController {

    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();
    private TableView<Aluno> table = new TableView<>();

    private static Long id = 0L;
    private StringProperty codProp = new SimpleStringProperty();
    private StringProperty nomeProp = new SimpleStringProperty();
    private ObjectProperty<Map<String,Integer>> notasProp = new SimpleObjectProperty<>();
    private IntegerProperty faltaProp = new SimpleIntegerProperty();

    private List<Materia> listaMaterias = new ArrayList<>();
    private List<Aluno> listaAlunos = new ArrayList<>();

    public void setEntity(Aluno aluno){
        if(aluno != null){

        }
    }


    public void pesquisar(){
        for (Materia m: listaMaterias){
            if(m.getCodMateria().contains(getCodProp())){
                listaAlunos = m.getAlunos();
            }
        }
    }

    public void generatedTable(){
        TableColumn<Aluno, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("Nome"));

        TableColumn<Aluno, Integer> col1Bim = new TableColumn<>("1 Bimestre");
        col1Bim.setCellValueFactory(new PropertyValueFactory<>("1 Bimestre"));

        TableColumn<Aluno, Integer> col2Bim = new TableColumn<>("2 Bimestre");
        col2Bim.setCellValueFactory(new PropertyValueFactory<>("2 Bimestre"));

        TableColumn<Aluno, Integer> col3Bim = new TableColumn<>("3 Bimestre");
        col3Bim.setCellValueFactory(new PropertyValueFactory<>("1 Bimestre"));

        TableColumn<Aluno, Integer> col4Bim = new TableColumn<>("4 Bimestre");
        col4Bim.setCellValueFactory(new PropertyValueFactory<Aluno, Integer>("4 Bimestre"));

        table.getColumns().addAll(colId, colNome, col1Bim, col2Bim, col3Bim, col4Bim);

        table.setItems(alunos);
    }


    public String getCodProp() {
        return codProp.get();
    }

    public StringProperty codPropProperty() {
        return codProp;
    }

    public void setCodProp(String codProp) {
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

    public Map<String, Integer> getNotasProp() {
        return notasProp.get();
    }

    public ObjectProperty<Map<String, Integer>> notasPropProperty() {
        return notasProp;
    }

    public void setNotasProp(Map<String, Integer> notasProp) {
        this.notasProp.set(notasProp);
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

    public TableView<Aluno> getTable() {
        return table;
    }
}
