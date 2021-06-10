package Boundary;

import Controller.LoginController;
import Entity.Comunicado;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
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
        d.put("admin","123");
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

        FlowPane fp = new FlowPane();

        MenuBar menu = new MenuBar();
        Menu notas = new Menu("Menu");
        MenuItem lancarNotas = new MenuItem("notas e faltas");
        menu.getMenus().addAll(notas);
        notas.getItems().addAll(lancarNotas);

        fp.getChildren().addAll(menu);

        BorderPane bp = new BorderPane();
        bp.setTop(fp);

        logar.setOnAction(event -> {
            if(loginController.validarUsuario(user.getText(), password.getText())){
                FXMLLoader rootAdm = new FXMLLoader(getClass().getResource("HomeAdm.fxml"));
                rootAdm.setController(new LoginBoundary());
                try {
                    Pane pane = rootAdm.load();
                    bp.setCenter(pane);
                    stage.getScene().setRoot(bp);
                    lancarNotas.setOnAction(ev -> {
                        stage.getScene().setRoot(materia.gerarTelaAdmin());
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                FXMLLoader rootUser = new FXMLLoader(getClass().getResource("HomeUser.fxml"));
                rootUser.setController(new LoginBoundary());
                try {
                    Pane pane = rootUser.load();
                    bp.setCenter(pane);
                    stage.getScene().setRoot(bp);
                    lancarNotas.setOnAction(ev -> {
                        stage.getScene().setRoot(materia.gerarTela());
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        grid.setAlignment(Pos.CENTER);

        stage.setTitle("Sistema de Comunicado Escolar");
        stage.setScene(sc);
        stage.show();
    }

    @FXML
    private void abrirModalEventos(){
        EventoBoundary ev = new EventoBoundary();
        ev.gerarTelaAdmin();
    }

    @FXML
    private void abrirModalComunicado(){
        ComunicadoBoundary com = new ComunicadoBoundary();
        com.gerarTelaAdmin();
    }

    public static void main(String[] args) {
        Application.launch(LoginBoundary.class, args);
    }
}
