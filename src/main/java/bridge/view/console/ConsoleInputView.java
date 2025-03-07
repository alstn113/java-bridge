package bridge.view.console;

import bridge.view.InputView;
import bridge.view.util.InputUtil;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public int readBridgeSize() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        return InputUtil.parseToInt(input);
    }

    @Override
    public String readMoving() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine();
    }

    @Override
    public String readGameCommand() {
        System.out.println();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return Console.readLine();
    }
}
