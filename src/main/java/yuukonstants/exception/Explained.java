package yuukonstants.exception;

/**
 * Represents a problem with a solution
 */
public interface Explained {

    String source();
    String message();
    String solution();


    default String toOutput() {
        return String.format("[%s]:\n\n An error has occurred: %s\n\nSolution: %s",source(), message(), solution());
    }


}
