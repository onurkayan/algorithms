package com.okayan.coursera.algorithms1.week3;

import org.junit.Test;

import static com.okayan.coursera.algorithms1.week3.SortHelper.isSorted;
import static org.junit.Assert.assertTrue;

public class InsertionTest {

    @Test
    public void testSort(){
        Integer[] a = {1,10,8,5,4,7,2};
        SelectionSort.sort(a);

        assertTrue(isSorted(a));

    }

}