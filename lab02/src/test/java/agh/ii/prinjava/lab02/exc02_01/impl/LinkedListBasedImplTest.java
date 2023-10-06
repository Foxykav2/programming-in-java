package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.L_LIST_B);
    private LinkedListBasedImpl stack;

    @BeforeEach
    void setUp() {

        stack= new LinkedListBasedImpl();

    }


    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void pop() {

    }

    @Test
    void push() {


    }

    @Test
    void numOfElems() {


    }

    @Test
    void peek() {
    }

    @Test
    void testIsEmpty() {
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPush() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.numOfElems());


    }

    @Test
    void testNumOfElems() {
        assertEquals(0, stack.numOfElems());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.numOfElems());
        stack.pop();
        assertEquals(1, stack.numOfElems());
    }

    @Test
    void testPeek() {
        stack.push(1);
        stack.push(10);
        assertEquals(10, stack.peek());
        assertEquals(2, stack.numOfElems());
    }
}