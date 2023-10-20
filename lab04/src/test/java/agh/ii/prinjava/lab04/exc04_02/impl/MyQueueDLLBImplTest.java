package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * We creat MyQueueDLLBImplTest class for testing MyQueueDLLBImpl methods
 * */
class MyQueueDLLBImplTest {
    MyQueue<Integer> queueOfInts;
    /**
     * When we begin a test, initialize a queue
     */
    @BeforeEach
    void setUp() {
        queueOfInts = MyQueue.create();
    }

    /**
     * After a test, we "remove" queue
     */
    @AfterEach
    void tearDown() { queueOfInts = null;
    }



    /**
     * We test toString from queueOfInts wich will be useful for our tests, we use assertEquals to compare the results
     */
    @Test
    void QtoString() {
        queueOfInts.enqueue(9);
        queueOfInts.enqueue(10);
        queueOfInts.enqueue(11);
        assertEquals("9 10 11",queueOfInts.toString());

    }


    /**
     * This test add a new node with enqueue to verify if its working, we use assertEquals to compare the results
     */
    @Test
    void enqueue() {
        queueOfInts.enqueue(5);
        queueOfInts.enqueue(6);
        queueOfInts.enqueue(7);
        assertEquals(3,queueOfInts.numOfElems());
        assertEquals("5 6 7",queueOfInts.toString());

    }

    /**
     * We check that dequeue remove the correct node and return its element, we use assertEquals to compare the results
     */
    @Test
    void dequeue() {
        queueOfInts.enqueue(5);
        queueOfInts.enqueue(6);
        queueOfInts.dequeue();
        assertEquals(1,queueOfInts.numOfElems());
        assertEquals(6,queueOfInts.dequeue());
    }

    /**
     * We test verify that numOfElems return the number of elements from the queue, we use assertEquals to compare the results
     */
    @Test
    void numOfElems() {
        queueOfInts.enqueue(4);
        queueOfInts.enqueue(5);
        assertEquals(2,queueOfInts.numOfElems());
        queueOfInts.dequeue();
        assertEquals(1,queueOfInts.numOfElems());
    }

    /**
     * This test see if peek return the top of the queue,  we use assertEquals to compare the results
     */
    @Test
    void peek() {
        queueOfInts.enqueue(9);
        queueOfInts.enqueue(8);
        assertEquals(9,queueOfInts.peek());

    }

}