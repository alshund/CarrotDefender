package listeners;

import javafx.geometry.Point2D;

public interface Observer {
    void changeCharacterPosition(double step);
    void addTracingBullet(double coordinateX, double coordinateY);
    void removeTracingBullet(int bulletIndex);
    void changeBulletPosition(double coordinateX, int bulletIndex);
    void addMovingEnemy(double coordinateX, double coordinateY);
    void removeMovingEnemy(int enemyIndex);
    void changeEnemyPosition(double coordinateX, int enemyIndex);
}
