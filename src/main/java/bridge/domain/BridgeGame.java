package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private boolean isFailed = false;
    private int tryCount = 1;
    private int currentPosition = -1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Moving moving) {
        int nextPosition = currentPosition + 1;
        String movingDirection = moving.getDirection();
        String canMoveDirection = bridge.get(nextPosition);

        currentPosition += 1;

        if (!movingDirection.equals(canMoveDirection)) {
            isFailed = true;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        isFailed = false;
        tryCount += 1;
        currentPosition = -1;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public boolean isCleared() {
        boolean isLastPosition = currentPosition == bridge.size() - 1;
        return isLastPosition && !isFailed;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
