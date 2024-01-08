package yuukonstants.exception;

/**
 * Represents a problem with a solution
 */
public interface Explained {

    String source();
    String type();
    String message();
    String solution();


    default String toOutput() {
        return String.format("[%s/%s]\n\n%s\n%s",source(), type(), message(), solution());
    }


}
