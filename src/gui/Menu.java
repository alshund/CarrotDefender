package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu {
    private BorderPane pane;
    private Button startGame;

    public Menu() {
        pane = new BorderPane();
        startGame = new Button("Start");
        pane.setCenter(startGame);
    }

    public BorderPane getPane() {
        return pane;
    }

    public Button getStartGame() {
        return startGame;
    }
}
