package present.activities.impl;

import present.command.KeyboardCommand;
import present.command.KeyboardDirector;
import javafx.scene.layout.*;
import present.activities.Activity;
import controller.Controller;
import javafx.scene.Scene;
import present.objectDesigns.Protagonist;

public class GameField implements Activity {

    private Scene scene;

    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    private GridPane gridPane = new GridPane();

    private double[] columns = {10, 10, 80};
    private double[] rows = {20, 20, 20, 20, 20};

    private KeyboardDirector keyboardDirector = new KeyboardDirector();

    private Protagonist protagonist;

    private Controller controller;

    public GameField(Controller controller) {

        this.controller = controller;
        gridPane = new GridPane();
        protagonist = new Protagonist();

        addColumns(columns);
        addRows(rows);


        gridPane.add(protagonist.getImageViewPane(), 0, 0);


        gridPane.setGridLinesVisible(true);
        scene = new Scene(gridPane, WIDTH, HEIGHT);
        scene.setOnKeyPressed(event -> {
            KeyboardCommand keyboardCommand = keyboardDirector.getKeyboardCommand(event.getCode());
            keyboardCommand.executed(protagonist);
        });
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
