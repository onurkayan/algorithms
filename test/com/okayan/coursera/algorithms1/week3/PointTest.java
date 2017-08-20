package com.okayan.coursera.algorithms1.week3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointTest {


    @Test
    public void testPositiveInfinite() throws Exception {
        Point p = new Point(64, 257);
        Point q = new Point(64, 257);
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(q), 0);

        p             = new Point(6019, 3629);
        q             = new Point(6019, 1474);
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(q), 0);
    }

    @Test
    public void testNegativeInfinite() throws Exception {
        Point p = new Point(357, 331);
        Point q = new Point(357, 331);

        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(q), 0);
    }

    @Test
    public void testSlopeTo() throws Exception {

        Point p1 = new Point(1,1);
        Point p2 = new Point(1,2);
        assertTrue(Double.isInfinite(p1.slopeTo(p2)));
        assertEquals(Double.POSITIVE_INFINITY,p1.slopeTo(p2),0);

        p2 = new Point(1,0);
        assertTrue(Double.isInfinite(p1.slopeTo(p2)));
        assertEquals(Double.POSITIVE_INFINITY,p1.slopeTo(p2),0);

        p2 = new Point(2,1);
        assertEquals(0.0,p1.slopeTo(p2),0.0);

    }
}