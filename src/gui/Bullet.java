package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet implements AnimationObject
{
    private Rectangle rectangle;
    private Pane pane;
    private AnimationTimer tracingAnimation;

    public Bullet() {
        rectangle = new Rectangle(10, 10, Color.GREEN);
        pane = new Pane();
        pane.getChildren().add(rectangle);
    }

    @Override
    public Pane getPane() {
        return pane;
    }

    @Override
    public double getWidth() {
        return pane.getWidth();
    }

    @Override
    public double getHeight() {
        return pane.getHeight();
    }

    @Override
    public void setCoordinateX(double coordinateX) {
        pane.setTranslateX(coordinateX);
    }

    @Override
    public double getCoordinateX() {
        return pane.getTranslateX();
    }

    @Override
    public void setCoordinateY(double coordinateY) {
        pane.setTranslateY(coordinateY);
    }

    @Override
    public double getCoordinateY() {
        return 0;
    }

    @Override
    public void setAnimationTimer(AnimationTimer animationTimer) {
        this.tracingAnimation = animationTimer;
    }

    @Override
    public AnimationTimer getAnimationTimer() {
        return tracingAnimation;
    }
}
