package Controller;

import DAO.NotasEFaltasDAO;
import DAO.NotasEFaltasDAOImpl;
import Entity.NotasEFaltas;
import javafx.beans.property.*;

public class NotasEFaltasController {

    private StringProperty DisciplinaProp = new SimpleStringProperty("");
    private StringProperty NomeDoAlunoProp = new SimpleStringProperty("");
    private StringProperty SerieProp = new SimpleStringProperty("");
    private StringProperty TurmaProp = new SimpleStringProperty("");
    private DoubleProperty Bimestre1Prop = new SimpleDoubleProperty();
    private DoubleProperty Bimestre2Prop = new SimpleDoubleProperty();
    private DoubleProperty Bimestre3Prop = new SimpleDoubleProperty();
    private DoubleProperty Bimestre4Prop = new SimpleDoubleProperty();
    private IntegerProperty Faltas = new SimpleIntegerProperty();
    private NotasEFaltasDAO notasEFaltasDAO = new NotasEFaltasDAOImpl();

    private void setEntity(NotasEFaltas notasEFaltas){
        if(notasEFaltas != null){
            DisciplinaProp.set(notasEFaltas.getDisciplina());
            NomeDoAlunoProp.set(notasEFaltas.getNomeDoAluno());
            SerieProp.set(notasEFaltas.getSerie());
            TurmaProp.set(notasEFaltas.getTurma());
            Bimestre1Prop.set(notasEFaltas.getBimestre1());
            Bimestre2Prop.set(notasEFaltas.getBimestre2());
            Bimestre2Prop.set(notasEFaltas.getBimestre3());
            Bimestre2Prop.set(notasEFaltas.getBimestre4());
            Faltas.set(notasEFaltas.getFaltas());
        }
    }

    private NotasEFaltas getEntity(){
        NotasEFaltas notasEFaltas = new NotasEFaltas();
        notasEFaltas.setDisciplina(DisciplinaProp.get());
        notasEFaltas.setNomeDoAluno(NomeDoAlunoProp.get());
        notasEFaltas.setSerie(SerieProp.get());
        notasEFaltas.setTurma(TurmaProp.get());
        notasEFaltas.setBimestre1(Bimestre1Prop.get());
        notasEFaltas.setBimestre2(Bimestre2Prop.get());
        notasEFaltas.setBimestre3(Bimestre3Prop.get());
        notasEFaltas.setBimestre4(Bimestre4Prop.get());
        notasEFaltas.setFaltas(Faltas.get());
        return notasEFaltas;
    }

    public void Salvar(){
        NotasEFaltas notasEFaltas = getEntity();
        notasEFaltasDAO.salvar(notasEFaltas);
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

    public String getTurmaProp() {
        return TurmaProp.get();
    }

    public StringProperty turmaPropProperty() {
        return TurmaProp;
    }

    public void setTurmaProp(String turmaProp) {
        this.TurmaProp.set(turmaProp);
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
