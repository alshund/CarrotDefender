package gui;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Character {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private Pane pane;
    private Rectangle rectangle;
    private PathTransition pathTransition;

    public Character() {
        rectangle = new Rectangle(WIDTH, HEIGHT,  Color.BLACK);
        pane = new BorderPane();
        pane.getChildren().add(rectangle);
        createPathTransition();
    }

    public Pane getPane() {
        return pane;
    }

    public double getWidth() {
        return rectangle.getWidth();
    }

    public double getHeight() {
        return rectangle.getHeight();
    }

    public double getCoordinateY() {
        return pane.getTranslateY();
    }

    private void createPathTransition() {

    }

    public void move() {
       pathTransition.play();
    }
}
