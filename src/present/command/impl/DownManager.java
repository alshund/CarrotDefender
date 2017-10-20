package present.command.impl;

import present.command.KeyboardCommand;
import present.objectDesigns.Protagonist;

public class DownManager implements KeyboardCommand {
    private final double DOWN_SPEED = 10;

    @Override
    public void executed(Protagonist protagonist) {
        double newCoordinate = protagonist.getImageViewPane().getTranslateY() + DOWN_SPEED;
        protagonist.getImageViewPane().setTranslateY(newCoordinate);
    }
}
