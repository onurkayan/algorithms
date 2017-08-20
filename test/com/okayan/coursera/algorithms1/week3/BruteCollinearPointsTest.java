package com.okayan.coursera.algorithms1.week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteCollinearPointsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNumberOfSegments() throws Exception {
        Point[] points = new Point[8];

        points[0] = new Point(10000,0);
        points[1] = new Point(0,10000);
        points[2]= new Point(3000,7000);
        points[3] = new Point(7000,3000);
        points[4] = new Point(20000,21000);
        points[5]= new Point(3000,4000);
        points[6] = new Point(14000,15000);
        points[7] = new Point(6000,7000);

        /*

        points[0] = new Point(19000,10000);
        points[1] = new Point(18000,10000);
        points[2]= new Point(32000,10000);
        points[3] = new Point(21000,10000);
        */







        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        //BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
//        StdIn.readChar();

        //assertEquals(1, bruteCollinearPoints.numberOfSegments());
    }

    @Test
    //@Ignore
    public void testInput6() throws Exception {

        Path path = Paths.get(".");
        System.out.println(path.toAbsolutePath().toString());
        In in = new In("resources/collinear/input56.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        //BruteCollinearPoints collinear2 = new BruteCollinearPoints(points);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();

        //StdIn.readChar();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArgument() throws Exception {
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstElement() throws Exception {
        Point[] points = new Point[1];
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() throws Exception {
        Point[] points = new Point[10];
        points[0] = new Point(7360, 2882);
        points[1] = new Point(31105, 1475);
        points[2]= new Point(23690, 22659);
        points[3] = new Point(23886, 21343);
        points[4] = new Point(2537,25300);
        points[5]= null;
        points[6] = new Point(15609,18439);
        points[7] = new Point(10983,4346);
        points[8] = new Point(22108,18764);
        points[9] = new Point(13172,27141);
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);

    }
}