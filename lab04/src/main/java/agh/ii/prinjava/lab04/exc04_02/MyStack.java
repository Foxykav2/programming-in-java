package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

/**
 * MyStack, an interface that we use to create stacks.
 * */
public interface MyStack<E> {
    /**
     *method that remove the value on the top of the stack
     * @return the first value removed
     */
    E pop();

    /**
     *method that add a new element at the top of the stack
     * @param x value of the element that we want to add att the top
     */
    void push(E x);

    /**
     * method that return the number of element of the stack
     * @return number of element of the stack
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * attribute that represents the number of elements of the stack
     */
    int numOfElems();

    /**
     * method that return the peek of the stack
     * @return the element at the top of the stack
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface
     * method that create an empty stack.
     * @return the stack created.
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}
