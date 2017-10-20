package present.command.impl;

import present.command.KeyboardCommand;
import present.objectDesigns.Protagonist;

public class SpaceManager implements KeyboardCommand {

    @Override
    public void executed(Protagonist protagonist) {
        protagonist.playAttackSprite();

    }
}
