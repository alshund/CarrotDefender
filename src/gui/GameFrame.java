package gui;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import controller.Controller;
import listeners.Observer;

import java.awt.*;

import static java.lang.Thread.sleep;

public class GameFrame implements Observer {
    private Stage stage;
    private Scene gameScene;
    private BorderPane gamePane;

    private Character character;

    private Controller controller;

    private Pane pane;

    public GameFrame(Controller controller) {
        this.controller = controller;





        character = new Character();
        gamePane = new BorderPane();
        gamePane.setLeft(character.getPane());
        gameScene = new Scene(gamePane, 1080, 640);

        gameScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                controller.move(5);
            } else if (event.getCode() == KeyCode.UP) {
                controller.move(-5);
            } else if (event.getCode() == KeyCode.SPACE) {
                Rectangle rectangle = new Rectangle(10, 10, Color.RED);
                Pane pane = new Pane(rectangle);
                gamePane.setBottom(pane);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (double i = 0.0; i < 10; i+=0.1) {
                            try {
                                sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pane.setTranslateX(pane.getTranslateX() + i);
                            System.out.println(pane.getTranslateX());
                        }

                    }
                });
                thread.start();

            }
        });

        controller.getGameLogic().setObserver(this);
        controller.getGameLogic().setCharacterPosition(character.getCharacterPosition());
        controller.getGameLogic().setCharacterDimension(character.getCharacterDimension());
    }

    @Override
    public Point2D move(int step) {
        character.getPane().setTranslateY(character.getPane().getTranslateY() + step);
        return character.getCharacterPosition();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return gameScene;
    }

    public void setScene(Scene gameField) {
        this.gameScene = gameField;
    }
}
