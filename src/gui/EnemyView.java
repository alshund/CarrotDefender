package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class EnemyView {
    private Pane enemyPane;
    private Rectangle rectangle;
    private AnimationTimer moveAnimation;

    public EnemyView() {
        rectangle = new Rectangle(64, 64, Color.BLUE);
        enemyPane = new Pane();
        enemyPane.getChildren().add(rectangle);
    }

    public Pane getEnemyPane() {
        return enemyPane;
    }

    public double getCoordinateX() {
        return enemyPane.getTranslateX();
    }

    public void setCoordinateX(double coordinateX) {
        enemyPane.setTranslateX(coordinateX);
    }

    public double getCoordinateY() {
        return enemyPane.getTranslateY();
    }

    public void setCoordinateY(double coordinateY) {
        enemyPane.setTranslateY(coordinateY);
    }

    public AnimationTimer getMoveAnimation() {
        return moveAnimation;
    }

    public void setMoveAnimation(AnimationTimer moveAnimation) {
        this.moveAnimation = moveAnimation;
    }
}
