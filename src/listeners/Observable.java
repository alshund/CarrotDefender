package listeners;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public interface Observable {
    void setObserver(Observer observer);
    void setCharacterPosition(Point2D characterPosition);
    void setCharacterDimension(Dimension2D characterDimension);
}
