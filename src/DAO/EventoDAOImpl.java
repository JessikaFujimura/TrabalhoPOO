package DAO;

import Entity.Evento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOImpl implements EventoDAO{

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    @Override
    public void adicionar(Evento e) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String insert = "INSERT INTO eventos (titulo,data,hora) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insert);
            preparedStatement.setString(1, e.getTitulo());
            preparedStatement.setDate(2, java.sql.Date.valueOf(e.getData()));
            preparedStatement.setString(3, e.getHora());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Evento> pesquisar(String t) {
        List<Evento> eventos = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String select = "SELECT * FROM eventos WHERE titulo LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setString(1, "%" + t + "%");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Long id = result.getLong("ID");
                String titulo = result.getString("TITULO");
                LocalDate data = result.getDate("DATA").toLocalDate();
                String hora = result.getString("HORA");
                Evento evento = new Evento();
                evento.setId(id);
                evento.setTitulo(titulo);
                evento.setData(data);
                evento.setHora(hora);
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventos;
    }

    @Override
    public void apagarPorId(Long id) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String delete = "DELETE FROM eventos WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(delete);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Long id, Evento e) {
        try {
         Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
         String update = "UPDATE eventos SET titulo=?, data=?, hora=? WHERE id=?";
         PreparedStatement preparedStatement = con.prepareStatement(update);
         preparedStatement.setString(1, e.getTitulo());
         preparedStatement.setDate(2, Date.valueOf(e.getData()));
         preparedStatement.setString(3, e.getHora());
         preparedStatement.setLong(4, id);
         preparedStatement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
