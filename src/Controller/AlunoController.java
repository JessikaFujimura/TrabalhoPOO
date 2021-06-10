package Controller;

import Boundary.NotasEFaltasBoundary;
import DAO.AlunoDAOImpl;
import Entity.Aluno;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

import java.util.List;

public class AlunoController {

    private static ObservableList<Aluno> alunos = FXCollections.observableArrayList();
    private static TableView<Aluno> table = new TableView<>();

    private AlunoDAOImpl alunoDAO = new AlunoDAOImpl();

    private static NotasEFaltasBoundary notasEFaltas = new NotasEFaltasBoundary();

    private StringProperty DisciplinaProp = new SimpleStringProperty();
    private StringProperty NomeDoAlunoProp = new SimpleStringProperty();
    private StringProperty SerieProp = new SimpleStringProperty();
    private DoubleProperty Bimestre1Prop = new SimpleDoubleProperty();
    private DoubleProperty Bimestre2Prop = new SimpleDoubleProperty();
    private DoubleProperty Bimestre3Prop = new SimpleDoubleProperty();
    private DoubleProperty Bimestre4Prop = new SimpleDoubleProperty();
    private IntegerProperty Faltas = new SimpleIntegerProperty();



    private void setEntity(Aluno aluno){
        if(aluno != null){
            NomeDoAlunoProp.set(aluno.getNome());
            SerieProp.set(aluno.getSerie());
            Bimestre1Prop.set(aluno.getN1());
            Bimestre2Prop.set(aluno.getN2());
            Bimestre2Prop.set(aluno.getN3());
            Bimestre2Prop.set(aluno.getN4());
            Faltas.set(aluno.getFaltas());
        }
    }

    private Aluno getEntity(){
        Aluno aluno = new Aluno();
        aluno.setNome(NomeDoAlunoProp.get());
        aluno.setSerie(SerieProp.get());
        aluno.setN1(Bimestre1Prop.get());
        aluno.setN2(Bimestre2Prop.get());
        aluno.setN3(Bimestre3Prop.get());
        aluno.setN4(Bimestre4Prop.get());
        aluno.setFaltas(Faltas.get());
        return aluno;
    }

    public void Salvar(){
        Aluno aluno = getEntity();
        alunoDAO.atualizar(aluno.getIdAluno(), aluno);
    }

    public void buscarAlunosPorMateria(Integer idMateria){
       List<Aluno> lista = alunoDAO.pesquisar(idMateria);
       alunos.addAll(lista);
    }

    public void generatedTable(){

        TableColumn<Aluno, Long> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("idAluno"));

        TableColumn<Aluno, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNome.setMinWidth(100);

        TableColumn<Aluno, String> colSerie = new TableColumn<>("Serie");
        colSerie.setCellValueFactory(new PropertyValueFactory<>("serie"));
        colSerie.setMinWidth(100);

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
                            flow.getChildren().addAll(btnEditar);
                            btnEditar.setOnAction(event -> {
                                table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                                    setEntity(newValue);
                                });
                                notasEFaltas.gerarTelaAdmin();
                            });

                            setGraphic(flow);
                            setText(null);
                        }

                    }
                };
            }
        };



        botoes.setCellFactory(cell);

        table.getColumns().addAll(colId, colNome,colSerie, col1Bim, col2Bim, col3Bim, col4Bim, faltas, botoes);

        table.setItems(alunos);

    }

    public TableView<Aluno> getTable() {
        return table;
    }

    public String getDisciplinaProp() {
        return DisciplinaProp.get();
    }

    public StringProperty disciplinaPropProperty() {
        return DisciplinaProp;
    }

    public void setDisciplinaProp(String disciplinaProp) {
        this.DisciplinaProp.set(disciplinaProp);
    }

    public String getNomeDoAlunoProp() {
        return NomeDoAlunoProp.get();
    }

    public StringProperty nomeDoAlunoPropProperty() {
        return NomeDoAlunoProp;
    }

    public void setNomeDoAlunoProp(String nomeDoAlunoProp) {
        this.NomeDoAlunoProp.set(nomeDoAlunoProp);
    }

    public String getSerieProp() {
        return SerieProp.get();
    }

    public StringProperty seriePropProperty() {
        return SerieProp;
    }

    public void setSerieProp(String serieProp) {
        this.SerieProp.set(serieProp);
    }

    public double getBimestre1Prop() {
        return Bimestre1Prop.get();
    }

    public DoubleProperty bimestre1PropProperty() {
        return Bimestre1Prop;
    }

    public void setBimestre1Prop(double bimestre1Prop) {
        this.Bimestre1Prop.set(bimestre1Prop);
    }

    public double getBimestre2Prop() {
        return Bimestre2Prop.get();
    }

    public DoubleProperty bimestre2PropProperty() {
        return Bimestre2Prop;
    }

    public void setBimestre2Prop(double bimestre2Prop) {
        this.Bimestre2Prop.set(bimestre2Prop);
    }

    public double getBimestre3Prop() {
        return Bimestre3Prop.get();
    }

    public DoubleProperty bimestre3PropProperty() {
        return Bimestre3Prop;
    }

    public void setBimestre3Prop(double bimestre3Prop) {
        this.Bimestre3Prop.set(bimestre3Prop);
    }

    public double getBimestre4Prop() {
        return Bimestre4Prop.get();
    }

    public DoubleProperty bimestre4PropProperty() {
        return Bimestre4Prop;
    }

    public void setBimestre4Prop(double bimestre4Prop) {
        this.Bimestre4Prop.set(bimestre4Prop);
    }

    public int getFaltas() {
        return Faltas.get();
    }

    public IntegerProperty faltasProperty() {
        return Faltas;
    }

    public void setFaltas(int faltas) {
        this.Faltas.set(faltas);
    }
}
