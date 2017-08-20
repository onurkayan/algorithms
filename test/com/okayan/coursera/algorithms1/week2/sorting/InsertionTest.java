package com.okayan.coursera.algorithms1.week2.sorting;

import org.junit.Test;

import static com.okayan.coursera.algorithms1.week2.sorting.SortHelper.isSorted;
import static org.junit.Assert.*;

public class InsertionTest {

    @Test
    public void testSort(){
        Integer[] a = {1,10,8,5,4,7,2};
        SelectionSort.sort(a);

        assertTrue(isSorted(a));

    }

}