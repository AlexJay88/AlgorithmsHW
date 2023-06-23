package Exceptions;



public class StringListIsFullException extends RuntimeException{
    public StringListIsFullException() {
        super();
    }

    public StringListIsFullException(String message) {
        super(message);
    }

    public StringListIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringListIsFullException(Throwable cause) {
        super(cause);
    }
}