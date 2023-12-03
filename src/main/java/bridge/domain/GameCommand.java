package bridge.domain;

import bridge.exception.ErrorMessage;
import bridge.exception.InvalidInputException;
import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new InvalidInputException(ErrorMessage.INVALID_GAME_COMMAND));
    }

    public String getCommand() {
        return command;
    }
}
