package com.okayan.coursera.algorithms1.week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.stream.IntStream;

/**
 * Created by onur on 13/08/2017.
 */
public class PercolationStats {

    private double[] fractions;

    public PercolationStats(int n,int trials){

        fractions = new double[trials];

        IntStream.range(0,trials).forEach( trial -> {
            Percolation percolation = new Percolation(n);

            while(!percolation.percolates()) {
                int p = StdRandom.uniform(1, n+1);
                int q = StdRandom.uniform(1, n+1);
                if (!percolation.isOpen(p,q))
                    percolation.open(p, q);
            }
            fractions[trial] = (double) percolation.numberOfOpenSites() / (n*n);
        });
    }

    public double mean(){
        return StdStats.mean(fractions);
    }

    public double stddev(){
        return StdStats.stddev(fractions);
    }

    public double confidenceLo(){
        return mean() - ((1.96 * stddev()) / Math.sqrt(fractions.length));
    }

    public double confidenceHi(){
        return mean() + ((1.96 * stddev()) / Math.sqrt(fractions.length));
    }

    public static void main(String[] args){
        if ( 2 != args.length)
            throw new IllegalArgumentException();

        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));

        System.out.println("mean                     = " + percolationStats.mean());
        System.out.println("stddev                   = " + percolationStats.stddev());
        System.out.printf("95%% confidence interval  = [%.15f,%.15f] \n", percolationStats.confidenceLo(),
                percolationStats.confidenceHi());
    }

}
