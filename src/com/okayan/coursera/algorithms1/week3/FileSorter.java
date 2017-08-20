package com.okayan.coursera.algorithms1.week3;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by onur on 17/08/2017.
 */
public class FileSorter {

    public static void main(String[] args){
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        Stream.of(files)
                .map(file -> file.getName())
                .forEach(StdOut::println);
    }

}
