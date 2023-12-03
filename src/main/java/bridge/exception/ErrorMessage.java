package bridge.exception;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력값이 숫자가 아닙니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
