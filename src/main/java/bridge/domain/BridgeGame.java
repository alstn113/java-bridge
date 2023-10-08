// BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

package bridge.domain;

import bridge.constant.BridgeConstant;
import bridge.constant.ErrorMessage;
import bridge.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;

    private final int totalAttempts;
    private List<String> history;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.totalAttempts = 1;
        this.history = new ArrayList<>();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (moving.equals(BridgeConstant.UP) || moving.equals(BridgeConstant.DOWN)) {
            this.history.add(moving);
        } else {
            throw new InvalidInputException(ErrorMessage.INVALID_MOVING_COMMAND);
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> getHistory() {
        return this.history;
    }

    public boolean isWin() {
        return true;
    }

    public boolean isEnd() {
        return true;
    }

    public boolean isRetry(String command) {
        if (command.equals(BridgeConstant.RETRY)) {
            this.retry();
            return true;
        } else if (command.equals(BridgeConstant.QUIT)) {
            return false;
        }
        throw new InvalidInputException(ErrorMessage.INVALID_GAME_COMMAND);
    }
}
