package com.okayan.coursera.algorithms1.week1;

/**
 * Created by onur on 10/08/2017.
 */
public class QuickUnionUF {

    private int id[];

    public QuickUnionUF(int N) {
        this.id = new int[N];
        for(int i=0; i< N;i++){
            id[i] = i;
        }
    }

    private int root(int i){
        while(i != id[i])
            i= id[i];
        return i;
    }

    public boolean connected(int p,int q){
        return root(p) == root(q);
    }

    public void union(int p,int q){
        int rootP = root(p);
        int rootQ = root(q);
        id[rootP] = rootQ;
    }

}
