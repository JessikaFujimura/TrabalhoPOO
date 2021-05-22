package Boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginController extends Application {

    private TextField user = new TextField();
    private PasswordField password = new PasswordField();

    private Button logar = new Button("Login");


    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane();
        Scene sc = new Scene(grid, 400, 00);

        grid.add(new Label(""), 3, 1);
        grid.add(new Label("Sistema de Comunidado Escolar"), 3, 2);
        grid.add(new Label(""), 3, 3);
        grid.add(new Label("Usuario"), 3, 4);
        grid.add(user, 5, 4);
        grid.add(new Label(""), 3, 5);
        grid.add(new Label("Senha"), 3, 6);
        grid.add(password, 5, 6);
        grid.add(new Label(""), 3, 7);
        grid.add(logar, 5, 8);


        stage.setTitle("Sistema de Comunicado Escolar");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(LoginController.class, args);
    }
}
