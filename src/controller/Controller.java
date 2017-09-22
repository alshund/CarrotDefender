package controller;

import listeners.Observer;
import model.GameLogic;

public class Controller {
    private GameLogic gameLogic;

    public Controller(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public void bunnyMovement(int step) {
        gameLogic.bunnyMovement(step);
    }

    public void attack() {
        gameLogic.attack();
    }

    public  void bulletTracing(int bulletIndex) {
        gameLogic.bulletTracing(bulletIndex);
    }

    public void removeTracingBullet(int bulletIndex) {
        gameLogic.removeTracingBullet(bulletIndex);
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameFieldDimension(double gameFieldWidth, double gameFieldHeight) {
        gameLogic.setGameFieldDimension(gameFieldWidth, gameFieldHeight);
    }

    public void setCharacterPosition(double coordinateX, double coordinateY) {
        gameLogic.setCharacterPosition(coordinateX, coordinateY);
    }

    public void setCharacterDimension(double characterWidth, double characterHigh) {
        gameLogic.setCharacterDimension(characterWidth, characterHigh);
    }

}
