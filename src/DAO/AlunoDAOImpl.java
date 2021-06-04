package DAO;

import Entity.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    private static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void adicionar(Aluno aluno) {

    }

    @Override
    public List<Aluno> pesquisar(int idMateria) {
        List<Aluno> alunos = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String select = "SELECT * FROM ALUNOS WHERE IDALUNO = ANY (SELECT IDALUNO FROM ALUNOSMAT WHERE IDMATERIA=?)";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setInt(1, idMateria);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Long id = result.getLong("IDALUNO");
                String nome = result.getString("NOMEALUNO");
                Double n1 = result.getDouble("N1");
                Double n2 = result.getDouble("N2");
                Double n3 = result.getDouble("N3");
                Double n4 = result.getDouble("N4");
                Integer faltas = result.getInt("FALTA");

                Aluno aluno = new Aluno();
                aluno.setIdAluno(id);
                aluno.setNome(nome);
                aluno.setN1(n1);
                aluno.setN2(n2);
                aluno.setN3(n3);
                aluno.setN4(n4);
                aluno.setFaltas(faltas);
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    @Override
    public void apagarPorId(Long id) {

    }

    @Override
    public void atualizar(Long id, Aluno aluno) {

    }
}
