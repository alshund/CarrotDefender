package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import controller.Controller;
import listeners.Observable;
import listeners.Observer;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class GameField implements Observer {
    private String[] map = {
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
      "0100000000",
    };


    private Stage stage;
    private Scene gameScene;
    private StackPane gamePane;

    private CharacterView characterView;

    private List<BulletView> tracingBulletViews = new LinkedList<>();
    private List<EnemyView> enemyWave = new LinkedList<>();

    private Controller controller;
    private Observable observable;

    public GameField(Controller controller) {
        this.controller = controller;

        observable = controller.getGameLogic();
        observable.setObserver(this);

        characterView = new CharacterView();
        gamePane = new StackPane();
        gamePane.getChildren().add(characterView.getPane());
        gameScene = new Scene(gamePane, 1080, 640);

        controller.setGameFieldDimension(gamePane.getWidth(), gamePane.getHeight());
        controller.setCharacterPosition(characterView.getCoordinateX(), characterView.getCoordinateY());
        controller.setCharacterDimension(characterView.getWidth(), characterView.getHeight());

        for (int indexRow = 0; indexRow < map.length; indexRow++) {
            for (int indexColumn = 0; indexColumn < map[indexRow].length(); indexColumn++) {
                Pane pane = new Pane();
                Rectangle rectangle;
                if (map[indexRow].charAt(indexColumn) == '1') {
                    rectangle = new Rectangle(64, 64, Color.RED);
                    pane.getChildren().add(rectangle);
                    gamePane.getChildren().add(pane);
                    pane.setTranslateX(indexColumn * 64);
                    pane.setTranslateY(indexRow * 64);
                }

            }
        }

        gameScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                controller.bunnyMovement(8);
            } else if (event.getCode() == KeyCode.UP) {
                controller.bunnyMovement(-8);
            } else if (event.getCode() == KeyCode.SPACE) {
                controller.attack();
            } else if (event.getCode() == KeyCode.ENTER) {
                controller.createEnemy();
            }
        });
    }

    @Override
    public void changeCharacterPosition(double coordinateY) {
        characterView.setCoordinateY(coordinateY);
    }

    @Override
    public void changeBulletPosition(double coordinateX, int bulletIndex) {
        BulletView bulletView = tracingBulletViews.get(bulletIndex);
        bulletView.setCoordinateX(coordinateX);
    }

    @Override
    public void addTracingBullet(double coordinateX, double coordinateY) {
        int bulletIndex = addBulletView(coordinateX, coordinateY);
        addBulletTracing(bulletIndex);
    }

    @Override
    public void removeTracingBullet(int bulletIndex) {
        tracingBulletViews.get(bulletIndex).getTracingAnimation().stop();
        gamePane.getChildren().remove(tracingBulletViews.get(bulletIndex).getPane());
        tracingBulletViews.remove(bulletIndex);
    }

    @Override
    public void addMovingEnemy(double coordinateX, double coordinateY) {
        int index = addEnemyView(coordinateX, coordinateY);
        addEnemyMoving(index);
    }

    @Override
    public void removeMovingEnemy(int enemyIndex) {

    }

    @Override
    public void changeEnemyPosition(double coordinateX, int enemyIndex) {
        EnemyView enemyView = enemyWave.get(enemyIndex);
        enemyView.setCoordinateX(coordinateX);
    }

    private int addEnemyView(double coordinateX, double coordinateY) {
        EnemyView enemyView = new EnemyView();
        gamePane.getChildren().add(enemyView.getEnemyPane());
        enemyView.setCoordinateX(coordinateX);
        enemyView.setCoordinateY(coordinateY);
        enemyWave.add(enemyView);
        return enemyWave.indexOf(enemyView);
    }

    private void addEnemyMoving(int enemyIndex) {
        EnemyView enemyView = enemyWave.get(enemyIndex);
        enemyView.setMoveAnimation(new AnimationTimer() {
            @Override
            public void handle(long now) {
                int enemyIndex = enemyWave.indexOf(enemyView);
                controller.enemyMove(enemyIndex);

            }
        });
        enemyView.getMoveAnimation().start();
    }

    private int addBulletView(double coordinateX, double coordinateY) {
        BulletView bulletView = new BulletView();
        gamePane.getChildren().add(bulletView.getPane());
        bulletView.setCoordinateX(coordinateX);
        bulletView.setCoordinateY(coordinateY);
        tracingBulletViews.add(bulletView);
        return tracingBulletViews.indexOf(bulletView);
    }

    private void addBulletTracing(int bulletIndex) {
        BulletView tracingBullet = tracingBulletViews.get(bulletIndex);
        tracingBullet.setTracingAnimation(new AnimationTimer() {
            @Override
            public void handle(long now) {
                int bulletIndex = tracingBulletViews.indexOf(tracingBullet);
                controller.bulletTracing(bulletIndex);
            }
        });
        tracingBullet.getTracingAnimation().start();

    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return gameScene;
    }

    public void setScene(Scene gameField) {
        this.gameScene = gameField;
    }
}
