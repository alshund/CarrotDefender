package model;

public class CharacterModel {
    private double width;
    private double height;
    private double coordinateX;
    private double coordinateY;
    private Weapon weapon;

    public CharacterModel() {
        weapon = new Pistol();
    }

    public BulletModel useWeapon() {
        return weapon.fire();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }
}
