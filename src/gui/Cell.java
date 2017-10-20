package gui;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cell {
    private StackPane pane;

    public Cell(String imagePath) {
        pane = new StackPane();
        pane.getChildren().add(createImageView(imagePath));
    }

    private ImageView createImageView(String imagePath) {
        Image image = new Image(imagePath, true);
        ImageView imageView = new ImageView(image);
        return imageView;
    }

    public StackPane getPane() {
        return pane;
    }
}
