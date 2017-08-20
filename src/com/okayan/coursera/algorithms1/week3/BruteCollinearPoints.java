package com.okayan.coursera.algorithms1.week3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by onur on 19/08/2017.
 */
public class BruteCollinearPoints {

    private final List<LineSegment> lineSegments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points){

        checkNullContent(points);
        Point[] pointsCopy = Arrays.copyOf(points,points.length);
        Arrays.sort(pointsCopy);
        checkDuplicates(pointsCopy);

        lineSegments = new ArrayList<>();
        for(int p = 0; p < pointsCopy.length-3; p++){
            for (int q=p+1; q < pointsCopy.length-2;q++ )
                for(int r = q+1 ; r < pointsCopy.length -1; r++)
                    for(int s = r+1; s < pointsCopy.length-0;s++){
                        if (Double.compare(pointsCopy[p].slopeTo(pointsCopy[q]), pointsCopy[p].slopeTo(pointsCopy[r])) ==0
                                && Double.compare(pointsCopy[p].slopeTo(pointsCopy[q]), pointsCopy[p].slopeTo(pointsCopy[s]))==0) {
                            lineSegments.add(new LineSegment(pointsCopy[p],pointsCopy[s]));
                        }
                    }
        }
    }

    // the number of line segments
    public int numberOfSegments(){
        return lineSegments.size();
    }

    // the line segments
    public LineSegment[] segments(){
        return lineSegments.toArray(new LineSegment[numberOfSegments()]);
    }

    private void checkNullContent(Point[] points) {
        if (null == points)
            throw new IllegalArgumentException();
        for(Point p : points)
            if (null == p)
                throw new IllegalArgumentException();
    }
    private void checkDuplicates(Point[] points) {
        for(int i=0;i < points.length-1;i++){
            if(points[i].compareTo(points[i+1]) == 0)
                throw new IllegalArgumentException();
        }
    }

}
