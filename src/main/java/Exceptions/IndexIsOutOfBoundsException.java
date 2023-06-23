package Exceptions;

public class IndexIsOutOfBoundsException extends RuntimeException{
    public IndexIsOutOfBoundsException() {
        super();
    }

    public IndexIsOutOfBoundsException(String message) {
        super(message);
    }

    public IndexIsOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexIsOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}