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
        return String.format("[%s/%s]\n\n problem: %s \n%s solution: %s ",source(), type(), message(), ExceptionUtil.ANSI_GREEN_BACKGROUND, solution());
    }


}
