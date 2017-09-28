package gui;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import listeners.Observable;
import listeners.Observer;

import java.util.LinkedList;
import java.util.List;

public class GameField implements Observer {
    public static final int ENEMY_WIDTH = 64;
    public static final int ENEMY_HEIGHT = 64;
    public static final int WINDOW_WIDTH = 1080;
    public static final int WINDOW_HEIGHT = 640;
    public static final int CHARACTER_UP_SPEED = 8;
    public static final int CHARACTER_DOWN_SPEED = -8;
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
    private Scene arenaScene;
    private StackPane arenaPane;

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

        arenaPane = new StackPane();
        arenaPane.getChildren().add(characterView.getPane());
        arenaScene = new Scene(arenaPane, WINDOW_WIDTH, WINDOW_HEIGHT);

        controller.setGameFieldDimension(arenaPane.getWidth(), arenaPane.getHeight());
        controller.setCharacterPosition(characterView.getCoordinateX(), characterView.getCoordinateY());
        controller.setCharacterDimension(characterView.getWidth(), characterView.getHeight());

        for (int indexRow = 0; indexRow < map.length; indexRow++) {
            for (int indexColumn = 0; indexColumn < map[indexRow].length(); indexColumn++) {
                Pane pane = new Pane();
                Rectangle rectangle;
                if (map[indexRow].charAt(indexColumn) == '1') {
                    rectangle = new Rectangle(ENEMY_WIDTH, ENEMY_HEIGHT, Color.RED);
                    pane.getChildren().add(rectangle);
                    arenaPane.getChildren().add(pane);
                    pane.setTranslateX(indexColumn * ENEMY_WIDTH);
                    pane.setTranslateY(indexRow * ENEMY_HEIGHT);
                }

            }
        }

        arenaScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                    controller.bunnyMovement(CHARACTER_UP_SPEED);
                } else if (event.getCode() == KeyCode.UP) {
                    controller.bunnyMovement(CHARACTER_DOWN_SPEED);
            } else if (event.getCode() == KeyCode.SPACE) {
                controller.attack();
            } else if (event.getCode() == KeyCode.ENTER) {
                controller.createEnemy();
            }
        });
    }

    private Scene createArenaScene(StackPane arenaPane) {
        return new Scene(arenaPane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private StackPane createArenaPane(CharacterView characterView) {
        StackPane arenaPane = new StackPane();
        arenaPane.getChildren().add(characterView.getPane());
        return arenaPane;
    }

    private CharacterView createCharacter() {
        characterView = new CharacterView();
        controller.setCharacterDimension(CharacterView.WIDTH, CharacterView.HEIGHT);
        controller.setCharacterPosition(characterView.getCoordinateX(), characterView.getCoordinateY());
        return characterView;
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
        arenaPane.getChildren().remove(tracingBulletViews.get(bulletIndex).getPane());
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
        arenaPane.getChildren().add(enemyView.getEnemyPane());
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
        arenaPane.getChildren().add(bulletView.getPane());
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
        return arenaScene;
    }

    public void setScene(Scene gameField) {
        this.arenaScene = gameField;
    }
}
