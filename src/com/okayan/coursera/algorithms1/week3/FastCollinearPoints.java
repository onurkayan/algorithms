package com.okayan.coursera.algorithms1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by onur on 19/08/2017.
 */
public class FastCollinearPoints {


    private final List<LineSegment> lineSegments;

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points){
        if(null == points)
            throw new IllegalArgumentException();
        Point[] pointsCopy = Arrays.copyOf(points,points.length);
        Arrays.sort(pointsCopy);
        checkDuplicates(pointsCopy);

        lineSegments = new ArrayList<>();
        for(int i = 0; i < pointsCopy.length; i++){
            Arrays.sort(pointsCopy);
            Point p1 = pointsCopy[i];
            Arrays.sort(pointsCopy,p1.slopeOrder());

            int first = 1;
            int last = 2;
            while (last < pointsCopy.length){
                double slope1 = p1.slopeTo(pointsCopy[first]);
                double slope2 = p1.slopeTo(pointsCopy[last]);
                if ( Double.compare(slope1, slope2) != 0) {
                    int dif = last - first;
                    if( dif >=3 && p1.compareTo(pointsCopy[first]) < 0)
                        lineSegments.add(new LineSegment(p1,pointsCopy[last-1]));
                    first = last;
                }
                    last++;
            }
            if( last - first >=3 && p1.compareTo(pointsCopy[first]) < 0)
                lineSegments.add(new LineSegment(p1,pointsCopy[last-1]));

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

    private void checkDuplicates(Point[] points) {
        for(int i=0;i < points.length-1;i++){
            if(points[i].compareTo(points[i+1]) == 0)
                throw new IllegalArgumentException();
        }
    }

}
