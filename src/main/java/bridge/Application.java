package bridge;

import bridge.controller.BridgeController;
import bridge.view.console.ConsoleInputView;
import bridge.view.console.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        new BridgeController(
                new ConsoleInputView(),
                new ConsoleOutputView()
        ).run();
    }
}
