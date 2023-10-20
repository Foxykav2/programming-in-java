package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DLinkListTest, a class that we use to test DLinkList methods
 * */
class DLinkListTest {
    DLinkList<Integer> dLinkList;

    /**
     * for each Test, we create a new List
     */
    @BeforeEach
    void setUp() {
       dLinkList = new DLinkList<>();
    }

    /**
     * after each test, we set the list at null
     */
    @AfterEach
    void tearDown() {
        dLinkList=null;
    }

    /**
     * This test use addLast methode. With the methode toString we can see if each value
     * are place att the end of the list.
     * In addition, we use numOfElems method to see if yhe list have increase
     */
    @Test
    void addLast() {
        dLinkList.addLast(8);
        dLinkList.addLast(6);
        dLinkList.addLast(4);
        assertEquals(3,dLinkList.numOfElems());
        assertEquals("8 6 4",dLinkList.toString());

    }

    /**
     * This test use addFirst methode. With the methode toString we can see if each value
     * are place att the top of the list.
     * In addition, we use numOfElems method to see if yhe list have increase
     */
    @Test
    void addFirst() {
        dLinkList.addFirst(8);
        dLinkList.addFirst(6);
        dLinkList.addFirst(4);

        assertEquals(3, dLinkList.numOfElems());
        assertEquals("4 6 8",dLinkList.toString());
    }

    /**
     * This test use removeLast methode.With the numOfElems method, we can see if our list have decrease.
     * Then we want to compare if the value deleted is correct
     */
    @Test
    void removeLast() {
        dLinkList.addFirst(5);
        dLinkList.addFirst(46);
        dLinkList.removeLast();
        assertEquals(1,dLinkList.numOfElems());
        assertEquals(46,dLinkList.removeFirst());



    }

    /**
     * This test use removeFirst methode.With the numOfElems method, we can see if our list have decrease.
     * Then we want to compare if the value deleted is correct
     */
    @Test
    void removeFirst() {
        dLinkList.addFirst(5);
        dLinkList.addFirst(46);
        dLinkList.removeFirst();
        assertEquals(1,dLinkList.numOfElems());
        assertEquals(5,dLinkList.removeFirst());

        
    }

    /**
     * In this Test, we increse and decrease the number of element of the list
     * and compared if it's correct.
     */
    @Test
    void numOfElems() {
        dLinkList.addFirst(5);
        dLinkList.addFirst(46);
        assertEquals(2,dLinkList.numOfElems());
        dLinkList.removeLast();
        assertEquals(1,dLinkList.numOfElems());

    }

    /**
     * On this test, we compare the resulat of the methode toSting to see if it's correct.
     */
    @Test
    void testToString() {
        dLinkList.addFirst(5);
        dLinkList.addFirst(46);
        assertEquals(2,dLinkList.numOfElems());
        assertEquals("46 5",dLinkList.toString());

    }
}