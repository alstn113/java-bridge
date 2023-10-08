package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void print(String message) {
        System.out.println(message);
    }

    public void printStartMessage() {
        print("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> history, boolean isFailed) {
        print(convertHistoryToString(history, isFailed, "U"));
        print(convertHistoryToString(history, isFailed, "D"));

    }

    public String convertHistoryToString(List<String> history, boolean isFailed, String positionToCheck) {
        StringBuilder result = new StringBuilder("[");

        for (int idx = 0; idx < history.size(); idx++) {
            String moving = history.get(idx);

            if (!moving.equals(positionToCheck)) {
                result.append("   ");
            } else if (idx == history.size() - 1 && isFailed) {
                result.append(" X ");
            } else {
                result.append(" O ");
            }

            if (idx < history.size() - 1) {
                result.append("|");
            }
        }

        result.append("]");
        return result.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> history, boolean isFailed, int totalAttempts) {
        print("\n최종 게임 결과");
        printMap(history, isFailed);
        print("게임 성공 여부: " + (isFailed ? "실패" : "성공"));
        print("총 시도한 횟수: " + totalAttempts);
    }

    public void printErrorMessage(String message) {
        print(message);
    }

}
