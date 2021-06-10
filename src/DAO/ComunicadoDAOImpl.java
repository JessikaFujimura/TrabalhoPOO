package DAO;

import Entity.Comunicado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComunicadoDAOImpl implements ComunicadoDAO{

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    @Override
    public void adicionar(Comunicado com) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String insert = "INSERT INTO comunicados (titulo,descricao) VALUES (?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insert);
            preparedStatement.setString(1, com.getTitulo());
            preparedStatement.setString(2, com.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Comunicado> pesquisar(String t) {
        List<Comunicado> comunicados = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String select = "SELECT * FROM comunicados WHERE titulo LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setString(1, "%" + t + "%");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Long id = result.getLong("ID");
                String titulo = result.getString("TITULO");
                String descricao = result.getString("DESCRICAO");
                Comunicado comunicado = new Comunicado();
                comunicado.setId(id);
                comunicado.setTitulo(titulo);
                comunicado.setDescricao(descricao);
                comunicados.add(comunicado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comunicados;
    }

    @Override
    public void apagarPorId(Long id) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String delete = "DELETE FROM comunicados WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(delete);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Long id, Comunicado com) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String update = "UPDATE eventos SET titulo=?, descricao=? WHERE id=?";
            PreparedStatement preparedStatement = con.prepareStatement(update);
            preparedStatement.setString(1, com.getTitulo());
            preparedStatement.setString(2, com.getDescricao());
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
