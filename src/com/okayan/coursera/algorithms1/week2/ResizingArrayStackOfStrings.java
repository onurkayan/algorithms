package com.okayan.coursera.algorithms1.week2;

import java.util.stream.IntStream;

/**
 * Created by onur on 14/08/2017.
 */
public class ResizingArrayStackOfStrings {

    private String[] stack;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        this.stack = new String[1];
    }


    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        if (stack.length == N)
            resize(2 * N);
        stack[N++]=item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        IntStream.range(0,N).forEach(i -> copy[i] = stack[i]);
        stack = copy;
    }

    public String pop(){
        String item = stack[--N];
        stack[N]=null;
        if ( N>0 && N == stack.length / 4) resize(stack.length / 2);
        return  item;
    }

}
