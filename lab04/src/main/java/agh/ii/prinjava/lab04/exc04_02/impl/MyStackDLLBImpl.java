package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;

/**
 * Création of stack implementation
 * @param <E> Type of each element of the list
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     *method that remove the value on the top of the stack
     * @return the first value removed
     */
    @Override
    public E pop() {

        return elems.removeFirst();
    }

    /**
     *method that add a new element at the top of the stack
     * @param x value of the element that we want to add att the top
     */
    @Override
    public void push(E x) {

        elems.addFirst(x);
    }

    /**
     * method that return the number of element of the stack
     * @return number of element of the stack
     */
    @Override
    public int numOfElems() {
        return elems.numOfElems();
    }

    /**
     * method that return the peek of the stack
     * @return the element at the top of the stack
     */
    @Override
    public E peek() {
        return elems.getFirst();
    }

    /**
     * Methode that return a string representation of the stack
     * @return a string representation of the stack
     */
    @Override
    public String toString(){
        return elems.toString();
    }
}
