package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

/**
 * class that initialise the Linked list
 */

public class LinkedListBasedImpl implements QueueOfInts {

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;

    /**
     *method that add a new Node at the list
     * @param x value of the Node that we want to add
     */
    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, last);// we set the Node to add
        if (last == null) {             //we add a condition to know if the list is null
            first = newNode;            // we add the node
        } else {                        // else
            last.next = newNode;        //the new node became the last
        }
        last = newNode;
        numOfElems++;                   // we increment the number of the liste
    }

    /**
     *
     * methode that delete a node of the list
     * @return the value of the Node that id deleted
     */
    @Override
    public int dequeue() {
        if (numOfElems == 0) {                      // we trow a exeption if the list is empty
            throw new EmptyQueueException("La file est vide");
        }
        int dequeuedValue = first.elem;     // we stoke the value the will be deleted from the list
        first = first.next;                 //we pointe the list to the next Node
        if (first == null) {                // if we only one elemente and we deleted it
            last = null;                    //  we set last at null too
        }
        numOfElems--;                       // we decrease the number of element
        return dequeuedValue;               // we return the value deleted
    }

    /**
     *
     * @return the number of elem of the list
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     *
     * @return the value of the first element
     */
    @Override
    public int peek() {
        if (numOfElems == 0) {
            throw new EmptyQueueException("La file est vide");
        }
        return first.elem;
    }


    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String message) {
            super(message);
        }
    }

}
