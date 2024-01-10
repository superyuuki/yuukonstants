package yuukonstants.exception;

import yuukonstants.exception.ExplainedException;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.function.Supplier;

import static java.lang.String.format;

public class ExceptionUtil {

    static final Queue<RuntimeException> EXCEPTIONS = new ArrayDeque<>();
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    static final String ANSI_BLACK = "\u001B[30m";


    public static <T> Supplier<T> wrapExceptionalSupplier(Supplier<T> runnable) {
        return () -> {
            try {
                return runnable.get();
            }  catch (LocatedException e) {
                System.out.println();
                System.out.println(format("at <%s>:", e.location.getAsTablePath()));
                System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + e.toOutput() + ANSI_RESET + ANSI_BLACK);
                System.out.println();
                System.out.println();
                if (e.getStackTrace().length >= 2) {
                    System.out.println();
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 1: " + e.getStackTrace()[0]);
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 2: " + e.getStackTrace()[1]);
                    System.out.println();
                    System.out.println();
                }
            }

            catch (ExplainedException e) {
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + e.toOutput() + ANSI_RESET + ANSI_BLACK);
                System.out.println();
                System.out.println();


                if (e.getStackTrace().length >= 2) {
                    System.out.println();
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 1: " + e.getStackTrace()[0]);
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 2: " + e.getStackTrace()[1]);
                    System.out.println();
                    System.out.println();
                }

            }

            return null;
        };
    }

    public static Runnable wrapExceptionalRunnable(Runnable runnable) {
        return () -> {
            try {
                runnable.run();
            }  catch (LocatedException e) {
                System.out.println();
                System.out.println(format("at <%s>:", e.location.getAsTablePath()));
                System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + e.toOutput() + ANSI_RESET);
                System.out.println();
                System.out.println();
                if (e.getStackTrace().length >= 2) {
                    System.out.println();
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 1: " + e.getStackTrace()[0]);
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 2: " + e.getStackTrace()[1]);
                }
            }

            catch (ExplainedException e) {
                System.out.println();
                System.out.println();
                System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + e.toOutput() + ANSI_RESET);
                System.out.println();
                System.out.println();


                if (e.getStackTrace().length >= 2) {
                    System.out.println();
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 1: " + e.getStackTrace()[0] + ANSI_RESET );
                    System.out.println(ANSI_RED_BACKGROUND + "stacktrace 2: " + e.getStackTrace()[1] + ANSI_RESET );
                }

            }

        };
    }



}
