package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

public interface MyQueue<E> {

    /**
     * A method that take a variable as param and return nothing, will be used to enqueue
     * @param x value
     */
    void enqueue(E x);

    /**
     * A method that have no param and return a variable, will be used to dequeue
     * @return E type variable
     */
    E dequeue();

    /**
     * A method that check if numOfElems is equal to 0 and return true or false, will to see if a queue is empty
     * @return a boolean that depend on numOfElems() return
     */

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * A method that return an int, will be used to see the number of elemnt of a queue
     * @return int
     */
    int numOfElems();

    /**
     * A method that have no param and return a variable, will be used to see the first element of a queue
     * @return E type variable
     */
    E peek();

    /** Consider pros and cons of having a factory method in the interface
     * . This method create a new queue
     * @return A new instance of MyQueue
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}
