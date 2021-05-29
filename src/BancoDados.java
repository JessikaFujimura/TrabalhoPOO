import java.sql.*;

public class BancoDados {

    public static final String URL = "jdbc:mariadb://localhost:3306/TRABPOO";
    public static final String USER = "root";
    public static final String PASSWORD = "";


    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado no bd");
            String insert = "INSERT INTO eventos (titulo,data,hora) VALUES ('Visita ao zoologico municipal', '2022-03-15', '09:00')";
            PreparedStatement preparedStatement = con.prepareStatement(insert);
            int linhasAfetadas = preparedStatement.executeUpdate();
            System.out.println("Linhas afetadas ==> " + linhasAfetadas);
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
