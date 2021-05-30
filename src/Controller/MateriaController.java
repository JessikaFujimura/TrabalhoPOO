package Controller;

import Entity.Aluno;
import javafx.beans.property.*;

public class MateriaController {

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Long id;
    private LongProperty codProp = new SimpleLongProperty();
    private StringProperty nomeProp = new SimpleStringProperty();
    private ObjectProperty<Aluno> notasProp = new SimpleObjectProperty<>();
    private IntegerProperty faltaProp = new SimpleIntegerProperty();

    AlunoController alunoController = new AlunoController();

    public void pesquisar(){
        alunoController.buscarAlunosPorMateria((int) codProp.get());
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
