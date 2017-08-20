package com.okayan.coursera.algorithms1.week2.sorting;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by onur on 17/08/2017.
 */
public class SortHelper {

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0 ;
    }

    public static void exch(Object[] a,int i,int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void shuffle(Object[] a){
        int n = a.length;
        for(int i = 0; i<n; i++){
            int r = StdRandom.uniform(i+1);
            exch(a,i,r);
        }
    }
}
