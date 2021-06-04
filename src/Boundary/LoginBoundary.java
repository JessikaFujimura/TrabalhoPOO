package Boundary;

import Controller.LoginController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class LoginBoundary extends Application {

    private TextField user = new TextField();
    private PasswordField password = new PasswordField();

    private Button logar = new Button("Login");
    private PatternStrategy materia = new MateriaBoundary();

    private LoginController loginController = new LoginController();

    @Override
    public void start(Stage stage) throws Exception {
        Map<String, String > d = new HashMap<String, String>();
        d.put("user","123");
        loginController.setCadastrados(d);

        GridPane grid = new GridPane();

        Scene sc = new Scene(grid, 1200, 600);
        sc.getStylesheets().add("./styles.css");

        grid.setMinSize(400,400);

        Text nomeDoSistema = new Text("Sistema de Comunidado Escolar");
        nomeDoSistema.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        nomeDoSistema.setTextAlignment(TextAlignment.CENTER);
        nomeDoSistema.setFill(Color.BLUEVIOLET);

        Label usuariolb = new Label("Usuario");
        Label senhalb = new Label("Senha");
        usuariolb.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        senhalb.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        logar.setPrefSize(150,40);
        logar.setTextFill(Color.GREEN);

        grid.setVgap(20);
        grid.setHgap(10);
        grid.add(nomeDoSistema, 1,1,2,1);
        grid.add(usuariolb, 1, 2);
        grid.add(user,2 , 2);
        grid.add(senhalb, 1, 3);
        grid.add(password, 2, 3);
        grid.add(logar, 1, 5, 2,1);

        logar.setOnAction(event -> {
            if(loginController.validarUsuario(user.getText(), password.getText())){
                stage.getScene().setRoot(materia.gerarTela());
            }
        });

        grid.setAlignment(Pos.CENTER);

        stage.setTitle("Sistema de Comunicado Escolar");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(LoginBoundary.class, args);
    }
}
