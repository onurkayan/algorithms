package com.okayan.coursera.algorithms1.week3;

import static com.okayan.coursera.algorithms1.week3.SortHelper.exch;
import static com.okayan.coursera.algorithms1.week3.SortHelper.less;

/**
 * Created by onur on 17/08/2017.
 */
public class Insertion{

    public static void sort(Comparable[] a){

        for(int i=0;i<a.length;i++){
            for (int j=i;j>=0;j--)
                if(less(a[j],a[j-1]))
                    exch(a,j,j-1);
                else
            break;
        }

    }

}
