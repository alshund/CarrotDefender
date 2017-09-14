package controller;

import javafx.fxml.Initializable;
import model.GameLogic;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private GameLogic gameLogic;

    public Controller(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public void move(int coordinate) {
        gameLogic.move(coordinate);
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

}
