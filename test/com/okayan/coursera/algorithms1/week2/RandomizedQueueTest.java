package com.okayan.coursera.algorithms1.week2;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    RandomizedQueue<Integer> randomizedQueue,q;

    @Before
    public void setUp() throws Exception {
        randomizedQueue = new RandomizedQueue<>();
        q = new RandomizedQueue<>();
    }

    @Test
    public void testEnqueue() throws Exception {
        randomizedQueue.enqueue(10);
        randomizedQueue.enqueue(20);
        randomizedQueue.enqueue(30);

        for(int i :randomizedQueue)
            System.out.println(i);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeue() throws Exception {
        randomizedQueue.enqueue(10);
//        randomizedQueue.enqueue(20);
/*        randomizedQueue.enqueue(30);
        randomizedQueue.enqueue(40);
        randomizedQueue.enqueue(50);
        randomizedQueue.enqueue(60);
        randomizedQueue.enqueue(70);
        randomizedQueue.enqueue(80);
        randomizedQueue.enqueue(90);
        randomizedQueue.enqueue(100);


        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        */
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
//        System.out.println(randomizedQueue.dequeue());

    }


    @Test
    public void testEnqueDequeue() throws Exception {

            for(int i=0;i<1000;i++) {
                int val = StdRandom.uniform(0, 10);
                randomizedQueue.enqueue(val);
            }

        for(int i=0;i<1000;i++) {
            randomizedQueue.sample();
            System.out.print(randomizedQueue.dequeue() + " ");
        }
        assertEquals(true,randomizedQueue.isEmpty());
        assertEquals(0,randomizedQueue.size());
    }


    @Test
    public void testDeque() throws Exception {

        for(int i=0;i<1000;i++) {
            int pos = StdRandom.uniform(0, 8);
            if (pos < 7) {
                if (!randomizedQueue.isEmpty())
                    randomizedQueue.dequeue();
            } else {
                randomizedQueue.enqueue(StdRandom.uniform(0, 100));
            }
        }





    }

    @Test
    public void testSample() throws Exception {
        randomizedQueue.enqueue(10);
        randomizedQueue.enqueue(20);
        randomizedQueue.enqueue(30);
        randomizedQueue.enqueue(40);
        randomizedQueue.enqueue(50);
        randomizedQueue.enqueue(60);
        randomizedQueue.enqueue(70);
        randomizedQueue.enqueue(80);
        randomizedQueue.enqueue(90);
        randomizedQueue.enqueue(100);

        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        System.out.println(randomizedQueue.sample());
        assertEquals(10,randomizedQueue.size());

        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        assertEquals(1,randomizedQueue.size());



    }


    @Test(expected = NoSuchElementException.class)
    public void testIterator() throws Exception {
        Iterator iterator = randomizedQueue.iterator();
        iterator.next();
    }



    @Test
    public void test_empty() {
        assertTrue(q.isEmpty());
        assertSame(0, q.size());
    }

    @Test(expected= IllegalArgumentException.class)
    public void test_add_null() {
        q.enqueue(null);
    }

    @Test(expected= NoSuchElementException.class)
    public void test_dequeue_empty() {
        q.dequeue();
    }

    @Test(expected= NoSuchElementException.class)
    public void test_sample_empty() {
        q.sample();
    }

    @Test(expected= NoSuchElementException.class)
    public void test_iter_next_empty() {
        Iterator<Integer> iter = q.iterator();
        iter.next();
    }

    @Test(expected= UnsupportedOperationException.class)
    public void test_iter_remove() {
        Iterator<Integer> iter = q.iterator();
        iter.remove();
    }

    @Test
    public void test_resize() {
        q.enqueue(1);
        q.enqueue(2);
        assertSame(2, q.size());
        assertFalse(q.isEmpty());
    }

    @Test
    public void test_add_del() {
        q.enqueue(1);
        assertSame(1, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    public void test_multiple_dels() {
        Integer[] ints = { 23, 5, 3, 67 };
        for (int i : ints) q.enqueue(i);
        assertSame(4, q.size());

        while(!q.isEmpty()) {
            assertTrue(Arrays.asList(ints).contains(q.dequeue()));
        }

        assertTrue(q.isEmpty());
    }

    @Test
    public void test_sample() {
        q.enqueue(4);
        assertSame(4, q.sample());
        assertSame(1, q.size());
        assertFalse(q.isEmpty());
    }

    @Test
    public void test_empty_iter() {
        Iterator<Integer> iter = q.iterator();
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_iter() {
        Integer[] ints = { 23, 5, 3, 67 };
        for (int i : ints) q.enqueue(i);

        for (Integer i : q) assertTrue(Arrays.asList(ints).contains(i));
        assertSame(4, q.size());
    }

    @Test
    public void test_iter_raw() {
        Integer[] ints = { 23, 5, 3, 67 };
        for (int i : ints) q.enqueue(i);

        Iterator<Integer> iter = q.iterator();
        assertTrue(iter.hasNext());
        assertTrue(Arrays.asList(ints).contains(iter.next()));
        assertTrue(iter.hasNext());
        assertTrue(Arrays.asList(ints).contains(iter.next()));
        assertTrue(iter.hasNext());
        assertTrue(Arrays.asList(ints).contains(iter.next()));
        assertTrue(iter.hasNext());
        assertTrue(Arrays.asList(ints).contains(iter.next()));
        assertFalse(iter.hasNext());
    }

    @Test
    public void test_empty_full_empty() {
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        assertFalse(q.isEmpty());
        assertSame(1, q.size());
        q.dequeue();
        assertTrue(q.isEmpty());
        assertSame(0, q.size());
        q.enqueue(3);
        assertFalse(q.isEmpty());
        assertSame(1, q.size());
    }

    @Test
    public void test_multiple_iters() {
        Integer[] ints = { 23, 5, 3, 67, 456, 9, 23, 68 };
        for (int i : ints) q.enqueue(i);

        /* Little awkward: Generate two iterators from the same queue and
         * step through each one in parallel. Test fails if both iterators
         * return the same values for each step, because the chances of that
         * happening by chance are very low. Test also fails if the value
         * returned doesn't exist in the source array, which shouldn't happen
         * (but might if something is super borked).
         */
        Integer[] a = new Integer[ints.length];
        Integer[] b = new Integer[ints.length];
        Iterator<Integer> iter_a = q.iterator();
        Iterator<Integer> iter_b = q.iterator();
        Integer x, y;
        boolean match = true;
        for (int i = 0; i < q.size() && match; i++) {
            x = iter_a.next();
            y = iter_b.next();
            if (x != y) match = false;
            assertTrue(Arrays.asList(ints).contains(x));
            assertTrue(Arrays.asList(ints).contains(y));
        }
        assertFalse(match);

    }

}