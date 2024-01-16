package xyz.auriium.yuukonstants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericPathTest {

    @Test
    void testTablePathShouldWorkLong() {
        var original = new GenericPath("sad", "creature", "house");

        assertEquals("sad/creature/house", original.tablePath());
    }

    @Test
    void testTablePathShouldWorkShort() {
        var original = new GenericPath("sad");

        assertEquals("sad", original.tablePath());
    }

    @Test
    void testOfShouldWorkAny() {
        var original = GenericPath.of("sad");

        assertEquals("sad", original.asArray()[0]);

        var original2 = GenericPath.of("sad/creature/house");

        assertEquals("sad", original2.asArray()[0]);
        assertEquals("creature", original2.asArray()[1]);
        assertEquals("house", original2.asArray()[2]);

    }
}