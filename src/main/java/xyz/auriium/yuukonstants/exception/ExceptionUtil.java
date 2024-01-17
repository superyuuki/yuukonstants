package xyz.auriium.yuukonstants.exception;

import java.util.ArrayDeque;
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


    static void print(LocatedException e) {
        System.out.println();
        System.out.println(format("at <%s>:", e.location.tablePath()));
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

    public static <T> Supplier<T> wrapExceptionalSupplier(Supplier<T> runnable) {
        return () -> {
            try {
                return runnable.get();
            }  catch (LocatedException e) {
                print(e);
            }catch (ExplainedException e) {
                print(e);
            }

            return null;
        };
    }

    public static Runnable wrapExceptionalRunnable(Runnable runnable) {
        return () -> {
            try {
                runnable.run();
            }  catch (LocatedException e) {
                print(e);
            } catch (ExplainedException e) {
                print(e);
            }

        };
    }



}
