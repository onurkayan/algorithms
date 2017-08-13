package com.okayan.coursera.algorithms1.week1;

/**
 * Created by onur on 11/08/2017.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.io.File;
import java.util.Scanner;

public class Percolation {

    private int[][] grid;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int openSites;

    public Percolation(int n){
        if (n <= 0 )
            throw new IllegalArgumentException();
        grid = new int[n][n];
        openSites=0;
        top = 0;
        bottom = n*n+1;
        for(int row=0; row< n; row++ ){
            for (int column=0;column<n;column++)
                grid[row][column] = -1;
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(n*n+2);
    }

    private void checkBoundaries(int row, int col) throws IllegalArgumentException{
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length)
            throw new IllegalArgumentException();
    }

    public void open(int row,int col) {
        if(!isOpen(row,col)){
            checkBoundaries(--row, --col);

            grid[row][col] = 0;
            openSites++;
            int n = grid.length;

            if (row == 0)
                weightedQuickUnionUF.union(top, getIndexOfWQUUF(row, col));

            if (row == n - 1)
                weightedQuickUnionUF.union(getIndexOfWQUUF(row, col), bottom);

            if (col - 1 >= 0 && isOpen(row+1,col))
                weightedQuickUnionUF.union(getIndexOfWQUUF(row, col), getIndexOfWQUUF(row, col - 1));
            if (col + 1 < n && isOpen(row+1,col+2))
                weightedQuickUnionUF.union(getIndexOfWQUUF(row, col), getIndexOfWQUUF(row, col + 1));
            if (row - 1 >= 0 && isOpen(row,col+1))
                weightedQuickUnionUF.union(getIndexOfWQUUF(row, col), getIndexOfWQUUF(row - 1, col));
            if (row + 1 < n && isOpen(row+2,col+1))
                weightedQuickUnionUF.union(getIndexOfWQUUF(row, col), getIndexOfWQUUF(row + 1, col));
        }
    }

    private int getIndexOfWQUUF(int row, int col) {
        return row * grid.length + col+ 1 ;
    }

    public boolean isOpen(int row, int col) {
        checkBoundaries(--row,--col);
        return grid[row][col] == 0 ;
    }

    public boolean isFull(int row,int col){
        checkBoundaries(--row,--col);
        return weightedQuickUnionUF.connected(top,getIndexOfWQUUF(row,col));
    }

    public int numberOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        return weightedQuickUnionUF.connected(top,bottom);
    }

    public static void main(String[] args){

        try(Scanner scanner = new Scanner(new File("src/resources/percolation/input10-no.txt"))){

            int n = Integer.valueOf(scanner.nextInt());
            Percolation percolation = new Percolation(n);
            while (scanner.hasNext()){
                percolation.open(scanner.nextInt(), scanner.nextInt());
            }


/*

            Percolation percolation = new Percolation(n);
            bufferedReader
                    .lines()
                    //.skip(1)
                    .filter(line -> !"".equals(line))
                    .forEach(line -> {
                        System.out.println(line);
                        String[] points = line.replaceAll("^\\s+|\\s+$", "").split(" ");
                        percolation.open(Integer.valueOf(points[0]), Integer.valueOf(points[1]));
                    });

*/
            System.out.println(percolation.numberOfOpenSites());
            System.out.println(percolation.percolates());

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
