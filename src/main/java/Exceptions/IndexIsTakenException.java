package Exceptions;



public class IndexIsTakenException extends RuntimeException{
    public IndexIsTakenException() {
        super();
    }


    public IndexIsTakenException(String message) {
        super(message);
    }

    public IndexIsTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexIsTakenException(Throwable cause) {
        super(cause);
    }
}
