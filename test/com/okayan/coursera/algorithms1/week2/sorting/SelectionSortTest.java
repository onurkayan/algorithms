package com.okayan.coursera.algorithms1.week2.sorting;

import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

import static com.okayan.coursera.algorithms1.week2.sorting.SortHelper.isSorted;
import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] a = {1,10,8,5,4,7,2};
        SelectionSort.sort(a);

        assertTrue(isSorted(a));

//        Arrays.stream(a).forEach(System.out::print);

    }


    @Test
    public void testInfinity() throws Exception {

        Double x = -1.0/0.0;

        assertTrue( Double.isInfinite(x));


    }
}