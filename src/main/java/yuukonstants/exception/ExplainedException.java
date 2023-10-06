package yuukonstants.exception;

public class ExplainedException extends RuntimeException implements Explained{

    final String source;
    final String solution;

    public ExplainedException(String source, String message, String solution) {
        super(message);
        this.source = source;
        this.solution = solution;
    }

    public ExplainedException(String source, String message, Throwable cause, String solution) {
        super(message, cause);
        this.source = source;
        this.solution = solution;
    }

    @Override
    public String source() {
        return source;
    }

    @Override
    public String message() {
        return getMessage();
    }

    @Override
    public String solution() {
        return solution;
    }
}
