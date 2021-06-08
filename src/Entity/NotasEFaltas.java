package Entity;

import javafx.beans.property.*;

public class NotasEFaltas {

    private StringProperty Disciplina = new SimpleStringProperty("");
    private StringProperty NomeDoAluno = new SimpleStringProperty("");
    private StringProperty Serie = new SimpleStringProperty("");
    private StringProperty Turma = new SimpleStringProperty("");
    private DoubleProperty Bimestre1 = new SimpleDoubleProperty();
    private DoubleProperty Bimestre2 = new SimpleDoubleProperty();
    private DoubleProperty Bimestre3 = new SimpleDoubleProperty();
    private DoubleProperty Bimestre4 = new SimpleDoubleProperty();
    private IntegerProperty Faltas = new SimpleIntegerProperty();

    public String getDisciplina() {
        return Disciplina.get();
    }

    public StringProperty disciplinaProperty() {
        return Disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.Disciplina.set(disciplina);
    }

    public String getNomeDoAluno() {
        return NomeDoAluno.get();
    }

    public StringProperty nomeDoAlunoProperty() {
        return NomeDoAluno;
    }

    public void setNomeDoAluno(String nomeDoAluno) {
        this.NomeDoAluno.set(nomeDoAluno);
    }

    public String getSerie() {
        return Serie.get();
    }

    public StringProperty serieProperty() {
        return Serie;
    }

    public void setSerie(String serie) {
        this.Serie.set(serie);
    }

    public String getTurma() {
        return Turma.get();
    }

    public StringProperty turmaProperty() {
        return Turma;
    }

    public void setTurma(String turma) {
        this.Turma.set(turma);
    }

    public double getBimestre1() {
        return Bimestre1.get();
    }

    public DoubleProperty bimestre1Property() {
        return Bimestre1;
    }

    public void setBimestre1(double bimestre1) {
        this.Bimestre1.set(bimestre1);
    }

    public double getBimestre2() {
        return Bimestre2.get();
    }

    public DoubleProperty bimestre2Property() {
        return Bimestre2;
    }

    public void setBimestre2(double bimestre2) {
        this.Bimestre2.set(bimestre2);
    }

    public double getBimestre3() {
        return Bimestre3.get();
    }

    public DoubleProperty bimestre3Property() {
        return Bimestre3;
    }

    public void setBimestre3(double bimestre3) {
        this.Bimestre3.set(bimestre3);
    }

    public double getBimestre4() {
        return Bimestre4.get();
    }

    public DoubleProperty bimestre4Property() {
        return Bimestre4;
    }

    public void setBimestre4(double bimestre4) {
        this.Bimestre4.set(bimestre4);
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
