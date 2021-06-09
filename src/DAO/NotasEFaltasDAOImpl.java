package DAO;

import Entity.NotasEFaltas;
import java.sql.*;

public class NotasEFaltasDAOImpl implements NotasEFaltasDAO{

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void salvar(NotasEFaltas n) {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String insert = "INSERT INTO notasEFaltas " +
                            "(Disciplina,NomeDoAluno,Serie,Turma,Bimestre1,Bimestre2,Bimestre3,Bimestre4,Faltas) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insert);
            preparedStatement.setString(1, n.getDisciplina());
            preparedStatement.setString(2, n.getNomeDoAluno());
            preparedStatement.setString(3, n.getSerie());
            preparedStatement.setString(4, n.getTurma());
            preparedStatement.setDouble(5, n.getBimestre1());
            preparedStatement.setDouble(6, n.getBimestre2());
            preparedStatement.setDouble(7, n.getBimestre3());
            preparedStatement.setDouble(7, n.getBimestre4());
            preparedStatement.setInt(8, n.getFaltas());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

