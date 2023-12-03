package bridge.domain;

import bridge.domain.generator.BridgeNumberGenerator;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.exception.ErrorMessage;
import bridge.exception.InvalidInputException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final String UP = "U";
    public static final String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public BridgeMaker() {
        this(new BridgeRandomNumberGenerator());
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBrideSize(size);
        return IntStream.range(0, size)
                .mapToObj(i -> generateBridgeShape())
                .collect(Collectors.toList());
    }

    private String generateBridgeShape() {
        int number = bridgeNumberGenerator.generate();
        if (number == 0) {
            return DOWN;
        }
        return UP;
    }

    private void validateBrideSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new InvalidInputException(ErrorMessage.INVALID_BRIDGE_SIZE);
        }
    }
}
