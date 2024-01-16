package xyz.auriium.yuukonstants.exception;

import xyz.auriium.yuukonstants.GenericPath;

public class LocatedException extends ExplainedException {

    final GenericPath location;

    public LocatedException(String source, String type, String message, String solution, GenericPath location) {
        super(source, type, message, solution);
        this.location = location;
    }

    public GenericPath location() {
        return location;
    }
}
