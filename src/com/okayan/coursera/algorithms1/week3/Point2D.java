package com.okayan.coursera.algorithms1.week3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by onur on 17/08/2017.
 */
public class Point2D {

    private final double x,y;

    public Point2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c){
        double area = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if(area < 0 ) return -1; //clockwise
        else if (area > 0 ) return 1; //counter-clockwise
        else return 0; //colliear
    }

    public static void grahamScan(){
        Point2D[] p = new Point2D[5];
        Stack<Point2D> hull = new Stack<>();

        Arrays.sort(p,(p1,p2)-> (int)(p1.y - p2.y) );
//        Arrays.sort(p,(p1,p2)-> (int)(p1.y - p2.y) Point2D.BY_POLAR_ORDER);

        hull.push(p[0]);
        hull.push(p[1]);

        for(int i = 2; i< p.length; i++){
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, p[i]) <= 0)
                top = hull.pop();
            hull.push(top);
            hull.push(p[i]);
        }
    }

    private static Comparator<Point2D> Y_ORDER = new Comparator<Point2D>() {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            return 0;
        }
    };

}
