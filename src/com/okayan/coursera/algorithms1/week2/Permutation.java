package com.okayan.coursera.algorithms1.week2;

import edu.princeton.cs.algs4.StdIn;
/**
 * Created by onur on 15/08/2017.
 */
public class Permutation {

    public static void main(String[] args) {

        if (args.length != 1)
            throw new IllegalArgumentException();
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        while (!StdIn.isEmpty())
            randomizedQueue.enqueue(StdIn.readString());

        while (k > 0) {
            System.out.println(randomizedQueue.dequeue());
            k--;
        }
    }
}