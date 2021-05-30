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
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
