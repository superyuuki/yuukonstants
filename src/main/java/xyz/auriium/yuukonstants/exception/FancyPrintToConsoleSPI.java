package xyz.auriium.yuukonstants.exception;

import org.kordamp.jipsy.annotations.ServiceProviderFor;

import static java.lang.String.format;

@ServiceProviderFor(ExceptionEatingSPI.class)
public class FancyPrintToConsoleSPI implements ExceptionEatingSPI {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    static final String ANSI_BLACK = "\u001B[30m";

    static void print(ExplainedException e) {
        System.out.println();
        System.out.println();
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + e.toOutput() + ANSI_RESET + ANSI_BLACK);
        System.out.println();
        System.out.println();


        if (e.getStackTrace().length >= 1) {
            System.out.println();

            for (int i = 0; i < Math.min(e.getStackTrace().length, 4); i++) {
                System.out.println(ANSI_RED_BACKGROUND + format("stacktrace %s: ", i) + e.getStackTrace()[i]);
            }
        }

        System.out.println(ANSI_RESET);
    }


    @Override
    public void exceptionHandlingFunction(ExplainedException exception) {

    }
}
