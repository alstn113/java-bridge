package bridge.exception;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력값이 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
