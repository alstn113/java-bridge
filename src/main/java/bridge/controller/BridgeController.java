package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    private Bridge bridge;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void progress() {
        while (true) {

            if (move()) continue;

            if (bridgeGame.isWin()) break;
            if (!isRetry()) break;
        }
    }

    public void printStartMessage() {
        outputView.printStartMessage();
    }

    public void printResult() {
        outputView.printResult();
    }

    public void makeBridge() {
        inputView.retryOnException(() -> {
            bridge = new Bridge(inputView.readBridgeSize());
            bridgeGame = new BridgeGame(bridge);
        });
    }

    private boolean move() {
        return inputView.retryOnException(() -> {
            boolean isCorrect = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getHistory(), bridgeGame.getIsFailed());
            return isCorrect;
        });
    }

    private boolean isRetry() {
        return inputView.retryOnException(() -> bridgeGame.isRetry(inputView.readGameCommand()));
    }


}
