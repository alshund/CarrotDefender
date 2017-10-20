package present.activities.impl;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import present.activities.Activity;
import present.command.KeyboardCommand;
import present.command.KeyboardDirector;
import present.objectDesigns.Protagonist;

public class GameField implements Activity {

    private Scene scene;

    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    private GridPane gridPane = new GridPane();

    private double[] columns = {10, 10, 80};
    private double[] rows = {20, 20, 20, 20, 20};

    private KeyboardDirector keyboardDirector = new KeyboardDirector();

    private Protagonist protagonist = new Protagonist();

    private Controller controller;

    public GameField(Controller controller) {

        this.controller = controller;
        addColumns(columns);
        addRows(rows);
        gridPane.getChildren().add(protagonist.getImageViewPane());
        scene = new Scene(gridPane, WIDTH, HEIGHT);
        protagonist.playFlightSprite();
        addCommandsListener();
    }

    private void addColumns(double...percentWidths) {

        for (double percentWidth : percentWidths) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(percentWidth);
            gridPane.getColumnConstraints().add(columnConstraints);
        }
    }

    private void addRows(double...percentHeights) {

        for (double percentHeight : percentHeights) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(percentHeight);
            gridPane.getRowConstraints().add(rowConstraints);
        }
    }

    private void addCommandsListener() {

        scene.setOnKeyPressed(event -> {
            KeyboardCommand keyboardCommand = keyboardDirector.getKeyboardCommand(event.getCode());
            keyboardCommand.executed(protagonist);
        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
