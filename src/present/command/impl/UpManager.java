package present.command.impl;

import present.command.KeyboardCommand;
import present.objectDesigns.Protagonist;

public class UpManager implements KeyboardCommand {
    public final double UP_SPEED = -10;

    @Override
    public void executed(Protagonist protagonist) {
        double newCoordinateY = protagonist.getImageViewPane().getTranslateY() + UP_SPEED;
        protagonist.getImageViewPane().setTranslateY(newCoordinateY);
    }
}
