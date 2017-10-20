package gui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


import java.util.LinkedList;

public class Arena {
    private BorderPane pane;
    private Character character;
    private LinkedList<Enemy> enemyWave;
    private LinkedList<Bullet> tracingBullets;

    public Arena() {
        pane = new BorderPane();
    }

    public BorderPane getPane() {
        return pane;
    }

    public Character getCharacter() {
        return character;
    }

    public LinkedList<Enemy> getEnemyWave() {
        return enemyWave;
    }

    public LinkedList<Bullet> getTracingBullets() {
        return tracingBullets;
    }
}
