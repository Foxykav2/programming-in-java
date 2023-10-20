package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void testPairConstructorAndGetters() {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        assertEquals(1, pair.getFirst());
        assertEquals("One", pair.getSecond());
    }

    @Test
    public void testPairSetters() {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        pair.setFirst(2);
        pair.setSecond("Two");
        assertEquals(2, pair.getFirst());
        assertEquals("Two", pair.getSecond());
    }

    @Test
    public void testPairToString() {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        assertEquals("(1, One)", pair.toString());
    }

    @Test
    public void testPairEquals() {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");
        Pair<Integer, String> pair3 = new Pair<>(2, "Two");
        assertTrue(pair1.equals(pair2));
        assertFalse(pair1.equals(pair3));
    }

    @Test
    public void testPairHashCode() {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");
        assertEquals(pair1.hashCode(), pair2.hashCode());
    }

    @Test
    public void testPairClone() {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = pair1.clone();
        assertTrue(pair1.equals(pair2));
        assertNotSame(pair1, pair2);
    }
}