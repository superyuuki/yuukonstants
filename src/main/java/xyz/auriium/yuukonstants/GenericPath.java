package xyz.auriium.yuukonstants;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Utility class
 */
public class GenericPath {


    public static GenericPath of(String stringWithSlash) {
        return new GenericPath(stringWithSlash.split("/"));
    }

    final String[] pathComposition;
    //final UUID uuid;

    public GenericPath(String... pathComposition) {
        this.pathComposition = pathComposition;
    }

    public String getTail() {
        return pathComposition[pathComposition.length - 1];
    }

    public String tablePath() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < pathComposition.length; i++) {
            if (i == (maxIndex())) {
                builder.append(pathComposition[i]);
            } else {
                builder.append(pathComposition[i]).append("/");
            }
        }

        return builder.toString();
    }


    public String tablePath(char splitter) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < pathComposition.length; i++) {
            if (i == (maxIndex())) {
                builder.append(pathComposition[i]);
            } else {
                builder.append(pathComposition[i]).append(splitter);
            }
        }

        return builder.toString();
    }

    public GenericPath sibling(String sibling) {
        if (sibling == null) throw new IllegalStateException("what");

        if (pathComposition.length == 0) {
            return new GenericPath(sibling);
        }

        String[] toReturnArray = pathComposition.clone();
        toReturnArray[pathComposition.length - 1] = sibling;

        return new GenericPath(toReturnArray);
    }

    public GenericPath append(String next) {
        if (next == null) throw new IllegalStateException("what");

        if (pathComposition.length == 0) {
            return new GenericPath(next);
        }

        String[] toReturnArray = new String[pathComposition.length + 1];
        System.arraycopy(pathComposition, 0, toReturnArray, 0, pathComposition.length);

        toReturnArray[pathComposition.length] = next;

        return new GenericPath(toReturnArray);
    }

    public int length() {
        return pathComposition.length;
    }

    public String getUniqueName(String name, Function<String, Boolean> toCheck) {

        int startAt = pathComposition.length - 1;

        if (!toCheck.apply(name)) {
            startAt -= 1;
        }

        var compound = Arrays.copyOfRange(pathComposition, startAt, pathComposition.length);

        StringBuilder use = new StringBuilder();

        for (String str : compound) {
            use.append(str).append("/");
        }

        return use.toString();
    }

    public String[] asArray() {
        return this.pathComposition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericPath that = (GenericPath) o;
        return Arrays.equals(pathComposition, that.pathComposition);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pathComposition);
    }

    public int maxIndex() {
        return pathComposition.length - 1;
    }



}
