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

public class Character extends Thread {
    private BorderPane characterPane;
    private Rectangle rectangle;

    public Character() {
        rectangle = new Rectangle(64, 64,  Color.BLACK);
        characterPane = new BorderPane();
        characterPane.getChildren().add(rectangle);
    }

    public BorderPane getPane() {
        return characterPane;
    }

    public void setPane(BorderPane characterPane) {
        this.characterPane = characterPane;
    }

    public Point2D getCharacterPosition() {
        return new Point2D(characterPane.getTranslateX(), characterPane.getTranslateY());
    }

    public Dimension2D getCharacterDimension() {
        return new Dimension2D(rectangle.getWidth(), rectangle.getHeight());
    }
}
