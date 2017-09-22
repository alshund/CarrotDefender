package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BulletView
{
    private Rectangle rectangle;
    private Pane pane;
    private AnimationTimer tracingAnimation;

    public BulletView() {
        rectangle = new Rectangle(10, 10, Color.GREEN);
        pane = new Pane();
        pane.getChildren().add(rectangle);
    }


    public Pane getPane() {
        return pane;
    }

    public double getWidth() {
        return pane.getWidth();
    }

    public double getHeight() {
        return pane.getHeight();
    }

    public void setCoordinateX(double coordinateX) {
        pane.setTranslateX(coordinateX);
    }

    public double getCoordinateX() {
        return pane.getTranslateX();
    }

    public void setCoordinateY(double coordinateY) {
        pane.setTranslateY(coordinateY);
    }

    public double getCoordinateY() {
        return pane.getTranslateY();
    }

    public AnimationTimer getTracingAnimation() {
        return tracingAnimation;
    }

    public void setTracingAnimation(AnimationTimer tracingAnimation) {
        this.tracingAnimation = tracingAnimation;
    }
}
