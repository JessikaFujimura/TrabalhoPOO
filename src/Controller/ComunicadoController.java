package Controller;

import DAO.ComunicadoDAO;
import DAO.ComunicadoDAOImpl;

import Entity.Comunicado;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ComunicadoController {

    private static Long id = 0L;
    private StringProperty tituloProp = new SimpleStringProperty("");
    private StringProperty descricaoProp = new SimpleStringProperty("");

    private ComunicadoDAOImpl comunicadoDAO = new ComunicadoDAOImpl();

    private void setEntity(Comunicado comunicado){
        if(comunicado != null){
            tituloProp.set(comunicado.getTitulo());
            descricaoProp.set(comunicado.getDescricao());
        }
    }

    private Comunicado getEntity(){
        Comunicado comunicado = new Comunicado();
        id++;
        comunicado.setId(id);
        comunicado.setTitulo(tituloProp.get());
        comunicado.setDescricao(descricaoProp.get());
        return comunicado;
    }

    public void adicionar(){
        Comunicado com = getEntity();
        comunicadoDAO.adicionar(com);
    }

    public String getTituloProp() {
        return tituloProp.get();
    }

    public StringProperty tituloPropProperty() {
        return tituloProp;
    }

    public void setTituloProp(String tituloProp) {
        this.tituloProp.set(tituloProp);
    }

    public String getDescricaoProp() {
        return descricaoProp.get();
    }

    public StringProperty descricaoPropProperty() {
        return descricaoProp;
    }

    public void setDescricaoProp(String descricaoProp) {
        this.descricaoProp.set(descricaoProp);
    }
}
