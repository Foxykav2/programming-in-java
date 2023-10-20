package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
/**
 * Creation of the queue class, this class will have appropriate mehtods for a queue and use a DLinkList as its only variable
 * @param <E> Type of each element of the queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     *enqueue add a new element to the queue at the last node
     * @param x value to add at the end of the queue
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * dequeue remove the first node of the list and give back its element
     * @return element from the first node
     */
    @Override
    public E dequeue() {
        return elems.removeFirst();
    }

    /**
     * This method is used to access numOfElems from the DLinkList class
     * @return number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return elems.numOfElems();
    }

    /**
     * This method is used to access the element from the first node in DLinkList class
     * @return element from the first node
     */
    @Override
    public E peek() {
        return elems.getFirst();
    }


    /**
     * This method is used tosee what is in the queue, principaly used in our test in MyQueueDLLBlmlTest
     * @return a string of all the element in order
     */

    @Override
    public String toString(){
        return elems.toString();
    }
}
