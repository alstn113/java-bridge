package bridge.exception;


import bridge.constant.ErrorMessage;

public class InvalidInputException extends AppException {
    public InvalidInputException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
