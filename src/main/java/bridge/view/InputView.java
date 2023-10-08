package bridge.view;

import bridge.constant.ErrorMessage;
import bridge.exception.AppException;
import bridge.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    private String read(String query) {
        outputView.print(query);
        return Console.readLine();
    }

    private Integer readInt(String query) {
        try {
            return Integer.parseInt(this.read(query));
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return this.readInt("다리의 길이를 입력해주세요.");
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return this.read("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return this.read("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public <T> T retryOnException(InputFunction<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.handleInput();
            } catch (AppException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void retryOnException(VoidInputFunction inputFunction) {
        while (true) {
            try {
                inputFunction.handleInput();
                return;
            } catch (AppException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    public interface InputFunction<T> {
        T handleInput() throws AppException;
    }

    @FunctionalInterface
    public interface VoidInputFunction {
        void handleInput() throws AppException;
    }

}
