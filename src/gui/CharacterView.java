package gui;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CharacterView {
    private Pane characterPane;
    private Rectangle rectangle;

    public CharacterView() {
        rectangle = new Rectangle(64, 64,  Color.BLACK);
        characterPane = new BorderPane();
        characterPane.getChildren().add(rectangle);
    }

    public Pane getPane() {
        return characterPane;
    }

    public double getWidth() {
        return rectangle.getWidth();
    }

    public double getHeight() {
        return rectangle.getHeight();
    }

    public double getCoordinateX() {
        return characterPane.getTranslateX();
    }

    public void setCoordinateY(double coordinateY) {
        characterPane.setTranslateY(coordinateY);
    }

    public double getCoordinateY() {
        return characterPane.getTranslateY();
    }
}
