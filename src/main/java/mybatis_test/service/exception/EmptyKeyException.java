package service.exception;

public class EmptyKeyException extends RuntimeException {
    public EmptyKeyException(String msg) {
        super(msg);
    }

    public EmptyKeyException(String msg, Throwable able) {
        super(msg, able);
    }
}