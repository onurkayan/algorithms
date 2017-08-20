package com.okayan.coursera.algorithms1.week3;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SelectionSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] a = {1,10,8,5,4,7,2};
        SelectionSort.sort(a);

        assertTrue(SortHelper.isSorted(a));

//        Arrays.stream(a).forEach(System.out::print);

    }


    @Test
    public void testInfinity() throws Exception {

        Double x = -1.0/0.0;

        assertTrue( Double.isInfinite(x));


    }
}