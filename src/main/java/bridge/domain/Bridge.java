package bridge.domain;

import bridge.BridgeMaker;
import bridge.constant.BridgeConstant;
import bridge.constant.ErrorMessage;
import bridge.exception.InvalidInputException;

import java.util.List;

public class Bridge {
    private final int length;
    private final BridgeMaker bridgeMaker;
    private final List<String> layout;

    public Bridge(int length) {
        this(length, new BridgeMaker());
    }

    public Bridge(int length, BridgeMaker bridgeMaker) {
        this.length = length;
        this.bridgeMaker = bridgeMaker;
        this.layout = this.bridgeMaker.makeBridge(length);
        validate(length);
    }


    public int getLength() {
        return length;
    }

    public List<String> getLayout() {
        return layout;
    }

    private void validate(int length) {
        validateBridgeLength(length);
    }

    private void validateBridgeLength(int length) {
        if (length < BridgeConstant.MIN_BRIDGE_SIZE || length > BridgeConstant.MAX_BRIDGE_SIZE) {
            throw new InvalidInputException(ErrorMessage.INVALID_BRIDGE_LENGTH);
        }
    }


}
