package com.okayan.coursera.algorithms1.week3;

import static com.okayan.coursera.algorithms1.week3.SortHelper.less;

/**
 * Created by onur on 17/08/2017.
 */
public class ShellSort {

    public static void sort(Comparable[] a){
        int n = a.length;

        int h=1;
        while (h < n/3 )
            h = 3 * h +1;

        while(h >=1){
            for(int i = h; i < n ;i++){
                for(int j = i; j>=h && less(a[j],a[j-h]); j -= h )
                    exch(a,j,j-h);
            }


            h = h/3;
        }

    }

    private static void exch(Comparable[] a, int j, int i) {
    }
}
