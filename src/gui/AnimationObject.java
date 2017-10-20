package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

/**
 * Created by shund on 29.09.2017.
 */
public interface AnimationObject {
    Pane getPane();
    double getWidth();
    double getHeight();
    void setCoordinateX(double coordinateX);
    double getCoordinateX();
    void setCoordinateY(double coordinateY);
    double getCoordinateY();
    void setAnimationTimer(AnimationTimer animationTimer);
    AnimationTimer getAnimationTimer();
}
