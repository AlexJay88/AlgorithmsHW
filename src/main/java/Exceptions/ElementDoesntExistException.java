package Exceptions;

public class ElementDoesntExistException extends RuntimeException{
    public ElementDoesntExistException() {
        super();
    }

    public ElementDoesntExistException(String message) {
        super(message);
    }

    public ElementDoesntExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementDoesntExistException(Throwable cause) {
        super(cause);
    }
}