package agh.ii.prinjava.lab03.exc03_01;

public interface QueueOfInts {
    /**
     * method that add a new Node at the list
     * @param x value of the Node that we want to add
     */
    void enqueue(int x);

    /**
     * methode that delete a node of the list
     * @return the value of the Node that id deleted
     */
    int dequeue();

    /**
     * methode that permit us to know if a list is empty
     * @return a boolean
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     *
     * @return the number of elem of the list
     */
    int numOfElems();

    /**
     *
     * @return the value of the first element
     */
    int peek();
}
