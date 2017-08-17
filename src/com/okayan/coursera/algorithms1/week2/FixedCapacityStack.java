package com.okayan.coursera.algorithms1.week2;

/**
 * Created by onur on 14/08/2017.
 */
public class FixedCapacityStack<Item> {

    private Item[] stack;
    private int N = 0;

    public FixedCapacityStack(int capacity) {
        this.stack = (Item[]) new Object[capacity];
    }


    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        stack[N++]=item;
    }

    public Item pop(){
        Item item = stack[--N];
        stack[N]=null;
        return  item;
    }

}
