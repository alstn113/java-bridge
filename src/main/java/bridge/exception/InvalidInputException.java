package bridge.exception;

public class InvalidInputException extends BaseException {
    public InvalidInputException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
