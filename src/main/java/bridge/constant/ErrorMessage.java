package bridge.constant;

public enum ErrorMessage {

    INVALID_BRIDGE_SIZE("다리의 길이는 2 이상이어야 합니다.");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
