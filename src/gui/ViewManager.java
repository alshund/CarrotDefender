package gui;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import listeners.Observable;
import listeners.Observer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ViewManager implements Observer {
    public static final int ENEMY_WIDTH = 64;
    public static final int ENEMY_HEIGHT = 64;
    public static final int WINDOW_WIDTH = 1080;
    public static final int WINDOW_HEIGHT = 640;
    public static final int CHARACTER_UP_SPEED = -8;
    public static final int CHARACTER_DOWN_SPEED = 8;
    private String[] map = {
      "xxxxxxxxxx",
      "xxxxxxxxxx",
      "xxxxxxxxxx",
      "xxxxxxxxxx",
      "xxxxxxxxxx",
      "gcggggsqbb",
      "gcggggsqbb",
      "gcggggsqbb",
      "gcggggsqbb",
      "gcggggsqbb",
    };

    private Stage stage;
    private Scene scene;

    private Map<String, Pane> panes;
    private GridPane arenaPane;

    private Character character;

    private List<Bullet> tracingBullets = new LinkedList<>();
    private List<Enemy> enemyWave = new LinkedList<>();

    private Controller controller;
    private Observable observable;

    public ViewManager(Controller controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;

        observable = controller.getGameLogic();
        observable.setObserver(this);

        panes = createPaneMap();

        setMenuPane();
        stage.show();




//        for (int indexRow = 0; indexRow < map.length; indexRow++) {
//            for (int indexColumn = 0; indexColumn < map[indexRow].length(); indexColumn++) {
//                Pane pane = new Pane();
//                Rectangle rectangle;
//                if (map[indexRow].charAt(indexColumn) == '1') {
//                    rectangle = new Rectangle(ENEMY_WIDTH, ENEMY_HEIGHT, Color.RED);
//                    pane.getChildren().add(rectangle);
//                    arenaPane.getChildren().add(pane);
//                    pane.setTranslateX(indexColumn * ENEMY_WIDTH);
//                    pane.setTranslateY(indexRow * ENEMY_HEIGHT);
//                }
//
//            }
//        }

//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.DOWN) {
//                characterMovement(CHARACTER_DOWN_SPEED);
////                    controller.bunnyMovement(CHARACTER_UP_SPEED);
//                } else if (event.getCode() == KeyCode.UP) {
//                characterMovement(CHARACTER_UP_SPEED);
////                    controller.bunnyMovement(CHARACTER_DOWN_SPEED);
//            } else if (event.getCode() == KeyCode.SPACE) {
//                controller.attack();
//            } else if (event.getCode() == KeyCode.ENTER) {
//                controller.createEnemy();
//            }
//        });
    }

    private Map createPaneMap() {
        Map<String, Pane> paneMap = new HashMap<>();
        paneMap.put(Menu.class.getName(), new Menu().getPane());
        paneMap.put(Arena.class.getName(), new Arena().getPane());
        return paneMap;
    }

    private void setMenuPane() {
        Pane menu = panes.get(Menu.class.getName());
        if (scene == null) {
            scene = new Scene(menu);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(menu);
        }
    }

    private void setArenaPane() {
        Pane arena = panes.get(Arena.class.getName());
        stage.getScene().setRoot(arena);
    }

    private void characterMovement(int step) {
        character.move();
    }

    private GridPane createArenaPane() {
        GridPane gridPane = new GridPane();
        for (int columnIndex = 0; columnIndex < map.length; columnIndex++) {
            for (int rowIndex = 0; rowIndex < map[columnIndex].length(); rowIndex++) {
                Cell cell;
                switch (map[rowIndex].charAt(columnIndex)) {
                    case 'x':
                        break;
                    case 'g':
                        cell = new Cell("g.png");
                        gridPane.add(cell.getPane(), columnIndex, rowIndex);
                        break;
                    case 'c':
//                        cell = new Cell("c.png");
//                        gridPane.add(cell.getPane(), rowIndex, columnIndex);
                        break;
                    case 's':
                        cell = new Cell("s.png");
                        gridPane.add(cell.getPane(), columnIndex, rowIndex);
                        break;
                    case 'q':
                        cell = new Cell("q.png");
                        gridPane.add(cell.getPane(), columnIndex, rowIndex);
                        break;
                    case 'b':
                        cell = new Cell("b.png");
                        gridPane.add(cell.getPane(), columnIndex, rowIndex);
                        break;
                }
            }
        }
        return gridPane;
    }

    @Override
    public void changeCharacterPosition(double coordinateY) {
//        character.setCoordinateY(coordinateY);
    }

    @Override
    public void changeBulletPosition(double coordinateX, int bulletIndex) {
        Bullet bullet = tracingBullets.get(bulletIndex);
        bullet.setCoordinateX(coordinateX);
    }

    @Override
    public void addTracingBullet(double coordinateX, double coordinateY) {
        int bulletIndex = addBulletView(coordinateX, coordinateY);
        addBulletTracing(bulletIndex);
    }

    @Override
    public void removeTracingBullet(int bulletIndex) {
        tracingBullets.get(bulletIndex).getAnimationTimer().stop();
        arenaPane.getChildren().remove(tracingBullets.get(bulletIndex).getPane());
        tracingBullets.remove(bulletIndex);
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
        Enemy enemy = enemyWave.get(enemyIndex);
        enemy.setCoordinateX(coordinateX);
    }

    private int addEnemyView(double coordinateX, double coordinateY) {
        Enemy enemy = new Enemy();
        arenaPane.getChildren().add(enemy.getPane());
        enemy.setCoordinateX(coordinateX);
        enemy.setCoordinateY(coordinateY);
        enemyWave.add(enemy);
        return enemyWave.indexOf(enemy);
    }

    private void addEnemyMoving(int enemyIndex) {
        Enemy enemy = enemyWave.get(enemyIndex);
        enemy.setAnimationTimer(new AnimationTimer() {
            @Override
            public void handle(long now) {
                int enemyIndex = enemyWave.indexOf(enemy);
                controller.enemyMove(enemyIndex);

            }
        });
        enemy.getAnimationTimer().start();
    }

    private int addBulletView(double coordinateX, double coordinateY) {
        Bullet bullet = new Bullet();
        arenaPane.getChildren().add(bullet.getPane());
        bullet.setCoordinateX(coordinateX);
        bullet.setCoordinateY(coordinateY);
        tracingBullets.add(bullet);
        return tracingBullets.indexOf(bullet);
    }

    private void addBulletTracing(int bulletIndex) {
        Bullet tracingBullet = tracingBullets.get(bulletIndex);
        tracingBullet.setAnimationTimer(new AnimationTimer() {
            @Override
            public void handle(long now) {
                int bulletIndex = tracingBullets.indexOf(tracingBullet);
                controller.bulletTracing(bulletIndex);
            }
        });
        tracingBullet.getAnimationTimer().start();

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene gameField) {
        this.scene = gameField;
    }
}
