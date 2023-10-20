package agh.ii.prinjava.proj1.impl;

/**
 * Creation of double linked list implementation
 * @param <E> Type of each element of the list
 */
public class DLinkList<E> {
    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;


    /**
     *method that add a new element at the end  of the list
     * @param x value of the element that we want to add att the end
     */
    public void addLast(E x) {
        Node newNode = new Node(x, null, last);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElems++;
    }
    /**
     * method that add a new element at the beginning of the list
     *@param x value of the element that we want to add first
     */
    public void addFirst(E x) {
        Node test = new Node(x,null,last);
        if (first == null) {
            last = test;
            first=test;
        } else {
            test.next=first;
            first=test;
        }
        numOfElems++;
    }

    /**
     * method that remove the Last value of the list
     * @return the last value removed
     */
    public E removeLast() {
        if (numOfElems == 0) {
            System.out.println("Queue is empty");
        }
        E removeValue = last.elem;
        last = last.prev;
        if (first == null) {
            last = null;
        }
        numOfElems--;
        return removeValue;
    }

    /**
     *method that remove the first value of the list
     * @return the first value removed
     */
  
    public E removeFirst() {
        E popelem = null;
        if (first == null ){
            System.out.println("Queue is empty");
        }
        else {
            popelem= first.elem;
            first=first.next;
            numOfElems--;

        }
        return popelem;
    }

    /**
     * method that return the number of element of the list
     * @return number of element of the list
     */
    public int numOfElems() {return numOfElems;}

    /**
     * Methode that return a string representation of the list
     * @return a string representation of the list
     */
    @Override
    public String toString(){
        StringBuilder List = new StringBuilder();
        Node test = first;
        while (test != null){
            List.append(test.elem).append(" ");
            test=test.next;
        }
        return List.toString().trim();
    }


    /**
     * Method that access last since it is private
     * @return element from last
     */
    public E getFirst(){
        if (first == null ){
            System.out.println("Queue is empty");
        }
        return first.elem;
    }


    /**
     * Class Node that allow us to create the linked list
     * it is the of each element of the list
     */
    private class Node {
        E elem;
        Node next;
        Node prev;

        public Node(E elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }



     
    }
}

