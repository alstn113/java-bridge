package bridge.view;

import bridge.exception.AppException;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Function;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private <T> T read(String query, Function<String, T> validator) {
        try {
            System.out.println(query);
            String input = Console.readLine();
            return validator.apply(input);
        } catch (Exception e) {
            if (e instanceof AppException) {
                System.out.println(e.getMessage());
                return this.read(query, validator);
            }
            throw e;
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(Function<String, Integer> validator) {
        return this.read("다리의 길이를 입력해주세요.", validator);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(Function<String, String> validator) {
        return this.read("이동할 칸을 선택해주세요. (위: U, 아래: D)", validator);

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(Function<String, String> validator) {
        return this.read("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", validator);
    }
}
