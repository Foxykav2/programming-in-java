package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {
    MyStack<Integer> stackOfInts = MyStack.create();

    /**
     * for each Test, we create a new stack
     */
    @BeforeEach
    void setUp() {
        stackOfInts = new MyStackDLLBImpl<>();
    }

    /**
     * after each test, we set the stack at null
     */
    @AfterEach
    void tearDown() {
        stackOfInts = null;
    }

    /**
     * This test use push methode. With the methode toString we can see if each value
     * are place at the top of the stack.
     * In addition, we use numOfElems method to see if the stack have increase
     */
    @Test
    void push(){
        stackOfInts.push(3);
        stackOfInts.push(5);
        stackOfInts.push(10);

        assertEquals(3, stackOfInts.numOfElems());
        assertEquals("10 5 3", stackOfInts.toString());
    }

    /**
     * This test use pop methode.With the numOfElems method, we can see if our stack has decrease.
     * Then we want to compare if the value deleted is correct
     */
    @Test
    void pop(){
        stackOfInts.push(12);
        stackOfInts.push(55);
        stackOfInts.pop();

        assertEquals(1, stackOfInts.numOfElems());
        assertEquals(12, stackOfInts.pop());
    }

    /**
     * In this Test, we increase and decrease the number of element of the stack
     * and compared if it's correct.
     */
    @Test
    void numOfElems(){
        stackOfInts.push(13);
        stackOfInts.push(104);

        assertEquals(2, stackOfInts.numOfElems());
        stackOfInts.pop();
        assertEquals(1, stackOfInts.numOfElems());
    }

    /**
     * On this test, we increase and decrease the number of element of the stack, and
     * we see if the peek returned is correct.
     */
    @Test
    void peek(){
        stackOfInts.push(35);
        stackOfInts.push(603);

        assertEquals(603, stackOfInts.peek());
        stackOfInts.pop();
        assertEquals(35, stackOfInts.peek());
    }

    /**
     * On this test, we compare the resulat of the methode toSting to see if it's correct.
     */
    @Test
    void ToString(){
        stackOfInts.push(23);
        stackOfInts.push(53);
        stackOfInts.push(20);

        assertEquals("20 53 23", stackOfInts.toString());
    }
}