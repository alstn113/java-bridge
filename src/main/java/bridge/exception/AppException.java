package bridge.exception;

public class AppException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public AppException(String message) {
        super(ERROR_PREFIX + message);
    }


}
