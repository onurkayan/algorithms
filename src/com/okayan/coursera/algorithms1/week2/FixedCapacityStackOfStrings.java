package com.okayan.coursera.algorithms1.week2;

/**
 * Created by onur on 14/08/2017.
 */
public class FixedCapacityStackOfStrings {

    private String[] stack;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        this.stack = new String[capacity];
    }


    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        stack[N++]=item;
    }

    public String pop(){
        String item = stack[--N];
        stack[N]=null;
        return  item;
    }

}
