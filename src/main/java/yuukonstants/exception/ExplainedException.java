package yuukonstants.exception;

public class ExplainedException extends RuntimeException implements Explained{

    final String source;
    final String type;
    final String solution;

    public ExplainedException(String source, String type, String message,  String solution) {
        super(message, null, false, false);
        this.source = source;
        this.type = type;
        this.solution = solution;
    }

    public ExplainedException(String source, String type, String message, Throwable cause,  String solution) {
        super(message, cause, false, false);
        this.source = source;
        this.type = type;
        this.solution = solution;
    }

    @Override
    public String source() {
        return source;
    }

    @Override
    public String type() {
        return type;
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
