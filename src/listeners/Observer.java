package listeners;

import javafx.geometry.Point2D;

public interface Observer {
    Point2D move(int step);
}
