package Boundary;

import javafx.scene.layout.Pane;

import java.io.IOException;

public interface PatternStrategy {

    Pane gerarTelaAdmin() throws IOException;
    Pane gerarTela();
}
