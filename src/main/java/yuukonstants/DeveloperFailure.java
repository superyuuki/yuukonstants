package yuukonstants;

@Deprecated
public class DeveloperFailure extends Failure {

    public DeveloperFailure() {
    }

    public DeveloperFailure(String message) {
        super(message);
    }

    public DeveloperFailure(String message, Throwable cause) {
        super(message, cause);
    }

    public DeveloperFailure(Throwable cause) {
        super(cause);
    }

    public DeveloperFailure(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
