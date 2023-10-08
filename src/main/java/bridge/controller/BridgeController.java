package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

        // 다리 길이 입력
        Bridge bridge = new Bridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        // 다리 이동
        while (true) {
            bridgeGame.move(inputView.readMoving()); // TODO: moving validate
            outputView.printMap(bridgeGame.getHistory());

            if (!bridgeGame.isEnd()) continue;

            if (bridgeGame.isWin()) break;

            if (bridgeGame.isRetry(inputView.readGameCommand())) {
                bridgeGame.retry();
            }
        }

        outputView.printResult();


    }
}
