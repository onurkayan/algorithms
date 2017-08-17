package com.okayan.coursera.algorithms.week2;

import com.okayan.coursera.algorithms1.week2.Deque;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    Deque<Integer> deque;
    @Before
    public void setUp() throws Exception {
        deque = new Deque<>();
    }

    @org.junit.Test
    public void testIsEmpty() throws Exception {
        assertEquals(true,deque.isEmpty());
    }

    @org.junit.Test
    public void testSize() throws Exception {
        assertEquals(0,deque.size());
        deque.addFirst(1);
        assertEquals(1,deque.size());
        deque.addLast(2);
        assertEquals(2,deque.size());
        deque.removeFirst();
        assertEquals(1,deque.size());
        deque.removeLast();
        assertEquals(0,deque.size());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddFirst() throws Exception {
        deque.addFirst(10);
        assertEquals(1,deque.size());
        deque.addFirst(20);
        assertEquals(2,deque.size());
        assertEquals(20, deque.removeFirst().intValue());
        deque.addFirst(null);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddLast() throws Exception {
        deque.addLast(10);
        assertEquals(1,deque.size());
        deque.addLast(20);
        assertEquals(2,deque.size());
        assertEquals(10, deque.removeFirst().intValue());
        assertEquals(20, deque.removeLast().intValue());
        deque.addLast(null);
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testRemoveFirst() throws Exception {
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);
        assertEquals(3, deque.size());
        assertEquals(10, deque.removeFirst().intValue());
        assertEquals(20, deque.removeFirst().intValue());
        assertEquals(30, deque.removeFirst().intValue());
        deque.removeFirst();
    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testRemoveLast() throws Exception {
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);
        assertEquals(3, deque.size());
        assertEquals(30, deque.removeLast().intValue());
        assertEquals(20, deque.removeLast().intValue());
        assertEquals(10, deque.removeLast().intValue());
        deque.removeLast();

    }

    @org.junit.Test(expected = NoSuchElementException.class)
    public void testIterator() throws Exception {
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);
        int i=0;
        for(int item:deque){
            if (i ==0) assertEquals(10,item);
            if (i ==1) assertEquals(20,item);
            if (i ==2) assertEquals(30,item);
            i++;
        }

        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        Iterator iterator = deque.iterator();
        iterator.next();
    }
}