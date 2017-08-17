package com.okayan.coursera.algorithms1.week2;

import java.util.Iterator;

/**
 * Created by onur on 14/08/2017.
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first = null;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item item){
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;
        first = newFirst;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }

}
