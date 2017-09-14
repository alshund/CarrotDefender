package model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import listeners.Observable;
import listeners.Observer;

public class GameLogic implements Observable {
    private CharacterModel characterModel;
    private Observer observer;

    public GameLogic() {
        characterModel = new CharacterModel();
    }

    @Override
    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void setCharacterPosition(Point2D point2D) {
        characterModel.setCharacterPosition(point2D);
    }

    @Override
    public void setCharacterDimension(Dimension2D dimension2D) {

    }

    public void move(int coordinate) {
        int step = coordinate > 0 ? 1 : -1;
        for (int indexY = 0; indexY < Math.abs(coordinate); indexY++) {
            observer.move(step);
        }
    }


}
