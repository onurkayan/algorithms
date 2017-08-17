package com.okayan.coursera.algorithms1.week2;

/**
 * Created by onur on 14/08/2017.
 */
public class LinkedStackOfStrings {

    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;
        first = newFirst;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }

}
