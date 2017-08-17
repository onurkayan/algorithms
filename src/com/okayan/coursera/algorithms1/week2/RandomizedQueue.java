package com.okayan.coursera.algorithms1.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by onur on 15/08/2017.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node head, tail;
    private int n;

    private class Node {
        private final Item item;
        private Node next;

        Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (null == item)
            throw new IllegalArgumentException();
        Node oldTail = tail;
        tail = new Node(item);
        n++;
        if (isEmpty())
            head = tail;
        else
            oldTail.next = tail;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node current = head, prev = null;
        int luckyNumber = StdRandom.uniform(0, n);
        while (current.next != null && luckyNumber > 0) {
            prev = current;
            current = current.next;
            luckyNumber--;
        }

        Item item = current.item;
        if (prev == null) { // remove from head
            head = head.next;
        } else
            prev.next = current.next;

        if (isEmpty())
            tail = null;

        n--;
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node current = head;
        int luckyNumber = StdRandom.uniform(0, n);
        while (current.next != null && luckyNumber > 0) {
            current = current.next;
            luckyNumber--;
        }
        return current.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private final RandomizedQueue<Item> queue;

        public ListIterator() {
            queue = new RandomizedQueue<>();
            Node first = head;
            while (first != null) {
                queue.enqueue(first.item);
                first = first.next;
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Item next(){
            if(queue.isEmpty())
                throw new NoSuchElementException();
            return queue.dequeue();
        }
    }
}