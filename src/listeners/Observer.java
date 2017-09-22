package listeners;

import javafx.geometry.Point2D;

public interface Observer {
    void changeCharacterPosition(double step);
    void addTracingBulletView(double coordinateX, double coordinateY);
    void removeTracingBullet(int bulletIndex);
    void changeBulletPosition(double coordinateX, int bulletIndex);
}
