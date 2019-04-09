package service.exception;

public class DuplicatedKeyException extends RuntimeException {
    public DuplicatedKeyException(String msg) {
        super(msg);
    }

    public DuplicatedKeyException(String msg, Throwable able) {
        super(msg, able);
    }
}