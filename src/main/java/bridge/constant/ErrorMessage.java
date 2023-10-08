package bridge.constant;

public enum ErrorMessage {

    INVALID_BRIDGE_LENGTH(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", BridgeConstant.MIN_BRIDGE_SIZE, BridgeConstant.MAX_BRIDGE_SIZE)),
    INPUT_NOT_A_NUMBER("숫자를 입력해주세요.");
    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
