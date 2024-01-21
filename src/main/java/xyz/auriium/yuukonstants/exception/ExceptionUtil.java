package xyz.auriium.yuukonstants.exception;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class ExceptionUtil {

    static List<ExceptionEatingSPI> contents;

    static List<ExceptionEatingSPI> access() {
        if (contents == null) {
            contents = ServiceLoader.load(ExceptionEatingSPI.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
        }
        return contents;
    }


    public static <T> Supplier<T> wrapExceptionalSupplier(Supplier<T> runnable) {



        return () -> {
            try {
                return runnable.get();
            } catch (ExplainedException e) {
                for (ExceptionEatingSPI spi : access()) {
                    spi.exceptionHandlingFunction(e);
                }
                throw new IllegalStateException(e); //make sure to stop the show

            }
        };
    }

    public static Runnable wrapExceptionalRunnable(Runnable runnable) {
        return () -> {
            try {
                runnable.run();
            }  catch (ExplainedException e) {
                for (ExceptionEatingSPI spi : access()) {
                    spi.exceptionHandlingFunction(e);
                }
                throw new IllegalStateException(e);
            }

        };
    }



}
