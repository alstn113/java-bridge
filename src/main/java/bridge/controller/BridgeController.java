package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.util.InputUtil;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        printGameStartMessage();
        List<String> bridge = createBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);

        while (!bridgeGame.isCleared()) {
            Moving moving = readMoving();
            bridgeGame.move(moving);
            printMap(bridgeGame);

            if (bridgeGame.isFailed() && !isRetry(bridgeGame)) {
                break;
            }
        }

        printResult(bridgeGame);
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        GameCommand gameCommand = readGameCommand();
        boolean retry = gameCommand == GameCommand.RETRY;
        if (retry) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private List<String> createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker();

        return InputUtil.retryOnException(() -> {
            int size = inputView.readBridgeSize();
            return bridgeMaker.makeBridge(size);
        });
    }

    private Moving readMoving() {
        return InputUtil.retryOnException(() -> {
            String input = inputView.readMoving();
            return Moving.of(input);
        });
    }

    private GameCommand readGameCommand() {
        return InputUtil.retryOnException(() -> {
            String input = inputView.readGameCommand();
            return GameCommand.of(input);
        });
    }

    private void printGameStartMessage() {
        outputView.printGameStartMessage();
    }

    private void printMap(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getCurrentPosition(), bridgeGame.isFailed());
    }

    private void printResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getCurrentPosition(), bridgeGame.isCleared(),
                bridgeGame.getTryCount());
    }
}
