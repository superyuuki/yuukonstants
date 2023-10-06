package yuukonstants;

@Deprecated
public class Failure extends RuntimeException {

    public Failure() {
    }

    public Failure(String message) {
        super(message);
    }

    public Failure(String message, Throwable cause) {
        super(message, cause);
    }

    public Failure(Throwable cause) {
        super(cause);
    }

    public Failure(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
