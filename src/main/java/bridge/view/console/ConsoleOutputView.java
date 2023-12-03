package bridge.view.console;

import bridge.view.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    @Override
    public void printMap() {

    }

    @Override
    public void printResult() {

    }
}
