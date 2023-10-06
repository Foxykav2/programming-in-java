package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

import javax.lang.model.type.NullType;

/**
 * Class LinkedListBasedImpl who implement a stack with a chained list
 */
public class LinkedListBasedImpl implements StackOfInts {
    /**
     *
     * @return int the value that is pop
     */
    @Override
    public int pop() {
        int popelem=0;// set the value

        if (first == null ){            // verification to see if the stack is emptie
            System.out.println("Stack is empty");
        }
        else {                          // if not
           popelem= first.elem;         //popelem get the element that will be deleted
           first=first.next;            // we set the stack to the item below the one who poped
           numOfElems--;                // we decrese the number of our stack

        }
        return popelem;         // return the poped value
    }

    /**
     * puch a new item in a stack
     * @param x int a number
     */
    @Override
    public void push(int x) {
        Node test = new Node(x,first); // we set the first value
        first = test;                   // the value is stacked
        numOfElems++;                   // increse the number of our stack

    }

    /**
     *
     * @return the number of element
     */
    @Override
    public int numOfElems() {
        System.out.println(numOfElems);
        return numOfElems;
    }

    /**
     *
     * @return the first value of the stack
     */
    @Override
    public int peek() {
        int Peak = first.elem;
        return Peak;
    }

    /**
     * its a Nested class that can create Node for the stack
     */
    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;

        }
    }

    private Node first = null;
    private int numOfElems = 0;
}
