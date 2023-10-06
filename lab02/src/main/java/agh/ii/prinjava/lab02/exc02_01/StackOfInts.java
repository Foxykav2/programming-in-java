package agh.ii.prinjava.lab02.exc02_01;

/**
 * Stack of integers - Abstract Data Type (ADT)
 */

public interface StackOfInts {
    /**
     *  methode pop, as for mission to delete the first element of a stack
     * @return INT the value deleted
     */
    int pop();

    /**
     * push méthode, as for mission to add X on the stack
     * @param x int a nuber
     *
     */

    void push(int x);

    /**
     *
     * @return Bool , to know if the stack is empty
     */

    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**

     * @return int ,the number of element in the stack
     */
    int numOfElems();

    /**
     *
     * @return int, the top value on the stack
     */

    int peek();
}
