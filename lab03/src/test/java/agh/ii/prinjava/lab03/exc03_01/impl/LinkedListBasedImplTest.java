package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListBasedImplTest {

    private final QueueOfInts queueOfInts = new LinkedListBasedImpl(); // Créez une instance de LinkedListBasedImpl

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void isEmpty() {
        assertTrue(queueOfInts.isEmpty());

        // Ajoutez un élément à la file
        queueOfInts.enqueue(21);

        // La file ne devrait plus être vide après l'ajout
        assertFalse(queueOfInts.isEmpty());
    }

    @Test
    void enqueue() {
        assertTrue(queueOfInts.isEmpty());

        queueOfInts.enqueue(78);
        assertEquals(1, queueOfInts.numOfElems());
    }

    @Test
    void dequeue() {
        assertTrue(queueOfInts.isEmpty());

        // Ajoutez un élément à la file
        queueOfInts.enqueue(4);

        int dequeuedValue = queueOfInts.dequeue();
        assertEquals(4, dequeuedValue);
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void numOfElems() {
        assertEquals(0, queueOfInts.numOfElems());

        // Ajoutez des éléments à la file
        queueOfInts.enqueue(55);
        queueOfInts.enqueue(56);
        queueOfInts.enqueue(57);

        assertEquals(3, queueOfInts.numOfElems());

        // Défilez un élément
        queueOfInts.dequeue();

        assertEquals(2, queueOfInts.numOfElems());
    }

    @Test
    void peek() {
        assertTrue(queueOfInts.isEmpty());

        // Ajoutez un élément à la file
        queueOfInts.enqueue(8);

        int peekedValue = queueOfInts.peek();
        assertEquals(8, peekedValue);
        assertFalse(queueOfInts.isEmpty());
    }
}