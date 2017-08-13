package com.okayan.coursera.algorithms1.week1;

/**
 * Created by onur on 10/08/2017.
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        this.id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    public boolean connected (int p,int q){
        return id[p] == id[q];
    }

    public void union(int p,int q){
        if(!connected(p,q)){
            int pid = id[p];
            for(int i=0; i < id.length; i++){
                if(id[i] == pid)
                    id[i] = id[q];
            }
        }
    }
}
