package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

import java.util.Vector;

/**
 * class ArrayBasedImpl that implment a stack with array
 */
public class ArrayBasedImpl implements StackOfInts {

    /**
     * my progrome doesn't work well, it have a problem with index out of bond
     * i will still add Doc to demonstrate the idee behinde this broken programe
     *
     * @return the valeur poped
     */
    @Override
    public int pop() {
        int ispopped = 0;             // we innitilised the poped value
        int[] Elem2 =null;              // we make a secode array

        if (Elem == null){              // if the stack have nothing, we have a messeage
            System.out.println("is empty");
        }
        else {                                   // if not
            ispopped = Elem[numOfElems -1];      // ispopped get the last element of the stack
            Elem2=Elem;                          // we make a copie of the stack

            numOfElems--;                        // we decresed our stack
            Elem = new int [numOfElems];         // we make a new list with -1 elem
            for (int i =0; i< numOfElems ;i++){  // we recreate manualie the liste with the precedent copie
                Elem[i]=Elem2[i];
            }
        }

        return ispopped;                         // we returned the poped value

    }

    @Override
/**
 * push a new value in the stack
 *
 * i have the same proble as the pop, index our of range
 */
    public void push(int x) {
        int[] Elem2 =null;          // we set a seconde array

        if (Elem == null){          // if the stack is empty, we add a x value
            Elem= new int [] {x};
        }
        else {                                         //if not
            Elem2=Elem;                                // we copied the stack
            numOfElems++;                              // we add an element on the stank
            Elem = new int [numOfElems];                // we create a new list
            for (int i =0; i< numOfElems -1;i++){       // we complete the stack with the seconde array
                Elem[i]=Elem2[i];

            }
        Elem[numOfElems-1]=x;                          // we add the value X at the array
        }

    }

    /**
     *
     * @return the number of element in the stack
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     *
     * @return the first element of the stack
     */
    @Override
    public int peek() {
        int test;
        test= Elem[numOfElems];
        return test;
    }

    private int numOfElems = 0;
    private int[] Elem = null;

}
