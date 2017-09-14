package model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public class CharacterModel {
    private Point2D characterPosition;
    private Dimension2D characterDimension;

    public Point2D getCharacterPosition() {
        return characterPosition;
    }

    public void setCharacterPosition(Point2D characterPosition) {
        this.characterPosition = characterPosition;
    }

    public Dimension2D getCharacterDimension() {
        return characterDimension;
    }

    public void setCharacterDimension(Dimension2D characterDimension) {
        this.characterDimension = characterDimension;
    }
}
