package bridge.controller;

import bridge.domain.BridgeMaker;
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

        while (true) {
            // 이동 반복
            // 실패 시 재시도 여부 확인
            // 성공 시 최종 게임 결과 확인, 시도 횟수
        }
    }

    private List<String> createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker();

        return InputUtil.retryOnException(() -> {
            int size = inputView.readBridgeSize();
            return bridgeMaker.makeBridge(size);
        });
    }

    private void printGameStartMessage() {
        outputView.printGameStartMessage();
    }
}
