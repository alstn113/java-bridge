package bridge.view.console;

import bridge.view.OutputView;
import java.util.List;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    @Override
    public void printMap(List<String> bridge, int currentPosition, boolean isFailed) {
        printMovingHistory(bridge, currentPosition, isFailed, "U");
        printMovingHistory(bridge, currentPosition, isFailed, "D");
    }


    private void printMovingHistory(List<String> bridge, int currentPosition, boolean isFailed, String side) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < currentPosition; i++) {
            if (bridge.get(i).equals(side)) {
                stringBuilder.append(" O ");
            } else {
                stringBuilder.append("   ");
            }
            stringBuilder.append("|");
        }
        if (isFailed && bridge.get(currentPosition).equals(side)) {
            stringBuilder.append("   ");
        } else if (isFailed && !bridge.get(currentPosition).equals(side)) {
            stringBuilder.append(" X ");
        } else if (bridge.get(currentPosition).equals(side)) {
            stringBuilder.append(" O ");
        } else {
            stringBuilder.append("   ");
        }

        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    @Override
    public void printResult(List<String> bridge, int currentPosition, boolean isCleared, int tryCount) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(bridge, currentPosition, !isCleared);
        System.out.println();
        if (isCleared) {
            System.out.println("게임 성공 여부: 성공");
        } else {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}