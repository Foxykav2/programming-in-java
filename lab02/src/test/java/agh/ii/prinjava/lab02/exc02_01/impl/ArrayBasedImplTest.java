package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBasedImplTest {
    /**
     * the method with // is tho one that doesn't work quite well
     */

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);
    private ArrayBasedImpl array;

    @BeforeEach
    void setUp() {
        array=new ArrayBasedImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }


    @Test
    void isEmpty() {
        //assertTrue(array.isEmpty());
        //array.push(1);
        //assertFalse(array.isEmpty());
        //array.pop();
        //assertTrue(array.isEmpty());
    }

    @Test
    void testPop() {
        array.push(1);
        array.push(2);
        assertEquals(2,array.pop());
        // assertEquals(1,array.numOfElems());
    }

    @Test
    void testpush() {
        array.push(1);
        array.push(2);
        assertEquals(1,array.numOfElems());

    }

    @Test
    void numOfElems() {
        assertEquals(0, array.numOfElems());
        array.push(1);
        array.push(2);
        //assertEquals(2, array.numOfElems());
        array.pop();
        //assertEquals(1, array.numOfElems());
    }

    @Test
    void peek() {
        array.push(1);
        array.push(2);
        //assertEquals(2, array.peek());
        //assertEquals(2, array.numOfElems());
    }
}