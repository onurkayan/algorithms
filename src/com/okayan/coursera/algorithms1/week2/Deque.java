package com.okayan.coursera.algorithms1.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by onur on 15/08/2017.
 */
public class Deque<Item> implements Iterable<Item> {

    private QueueNode head, tail;
    private int size;

    private class QueueNode {
        private final Item item;
        private QueueNode next;
        private QueueNode previous;

        QueueNode(Item item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    // construct an empty deque
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (null == item)
            throw new IllegalArgumentException();
        QueueNode oldHead = head;
        head = new QueueNode(item);
        head.next = oldHead;

        if (isEmpty()) {
            tail = head;
        } else {
            oldHead.previous = head;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (null == item)
            throw new IllegalArgumentException();
        QueueNode oldTail = tail;
        tail = new QueueNode(item);
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
            tail.previous = oldTail;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item item = head.item;
        head = head.next;
        size--;
        if (isEmpty())
            tail = null;
        else
            head.previous = null;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item item = tail.item;
        tail = tail.previous;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private QueueNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null)
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}