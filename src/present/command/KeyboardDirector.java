package present.command;

import present.command.impl.*;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class KeyboardDirector {

    private Map<KeyCode, KeyboardCommand> commands = new HashMap<>();

    public KeyboardDirector() {
        commands.put(KeyCode.UP, new UpManager());
        commands.put(KeyCode.DOWN, new DownManager());
        commands.put(KeyCode.SPACE, new SpaceManager());
    }

    public KeyboardCommand getKeyboardCommand(KeyCode keyCode) {
        return commands.get(keyCode);
    }
}
