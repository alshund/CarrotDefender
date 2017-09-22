package model;

import listeners.Observable;
import listeners.Observer;

import java.util.ArrayList;
import java.util.List;

public class GameLogic implements Observable {
    private double gameFieldWidth;
    private double gameFieldHeight;
    private CharacterModel characterModel;
    private List<BulletModel> flyingBullets;
    private Observer observer;

    public GameLogic() {
        characterModel = new CharacterModel();
        flyingBullets = new ArrayList<BulletModel>();
    }

    @Override
    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void bunnyMovement(int step) {
        double newCoordinateY = characterModel.getCoordinateY() + step;
        if (0 <= newCoordinateY && newCoordinateY + characterModel.getHeight() <= gameFieldHeight) {
            characterModel.setCoordinateY(newCoordinateY);
            observer.changeCharacterPosition(newCoordinateY);
        }
    }

    public void attack() {
        double startX = characterModel.getCoordinateX() + characterModel.getWidth();
        double startY = characterModel.getCoordinateY() + characterModel.getHeight() / 2;
        BulletModel bullet = characterModel.useWeapon();
        bullet.setCoordinateX(startX);
        bullet.setCoordinateY(startY);
        flyingBullets.add(bullet);
        observer.addTracingBulletView(startX, startY);
    }

    public void bulletTracing(int bulletIndex) {
        BulletModel bullet = flyingBullets.get(bulletIndex);
        bullet.setCoordinateX(bullet.getCoordinateX() + 15);
        if (flyingBullets.get(bulletIndex).getCoordinateX() < gameFieldWidth) {
            observer.changeBulletPosition(bullet.getCoordinateX(), bulletIndex);
        } else {
            removeTracingBullet(bulletIndex);
        }
    }

    public void removeTracingBullet(int bulletIndex) {
        flyingBullets.remove(bulletIndex);
        observer.removeTracingBullet(bulletIndex);
    }

    public void setGameFieldDimension(double gameFieldWidth, double gameFieldHeight) {
        this.gameFieldWidth = gameFieldWidth;
        this.gameFieldHeight = gameFieldHeight;
    }

    public void setCharacterPosition(double coordinateX, double coordinateY) {
        characterModel.setCoordinateX(coordinateX);
        characterModel.setCoordinateY(coordinateY);
    }

    public void setCharacterDimension(double width, double height) {
        characterModel.setWidth(width);
        characterModel.setHeight(height);
    }
}