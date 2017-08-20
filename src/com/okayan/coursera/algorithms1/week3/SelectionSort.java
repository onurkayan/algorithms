package com.okayan.coursera.algorithms1.week3;

import static com.okayan.coursera.algorithms1.week3.SortHelper.exch;
import static com.okayan.coursera.algorithms1.week3.SortHelper.less;

/**
 * Created by onur on 17/08/2017.
 */
public class SelectionSort {

    public static void sort(Comparable[] a){

        for (int i=0; i<a.length;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j],a[min]))
                    min = j;
            }
            if (i != min)
                exch(a,i,min);
        }
    }
}
