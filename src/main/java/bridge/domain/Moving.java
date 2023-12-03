package bridge.domain;

import bridge.exception.ErrorMessage;
import bridge.exception.InvalidInputException;
import java.util.Arrays;

public enum Moving {
    UP("U"),
    DOWN("D");

    private final String direction;

    Moving(String direction) {
        this.direction = direction;
    }

    public static Moving of(String direction) {
        return Arrays.stream(Moving.values())
                .filter(moving -> moving.direction.equals(direction))
                .findFirst()
                .orElseThrow(() -> new InvalidInputException(ErrorMessage.INVALID_MOVING));
    }

    public String getDirection() {
        return direction;
    }
}
