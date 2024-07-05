package com.hry.objectPool;

public class Main {
    public static void main(String[] args) {
        // Create and use Point objects without pooling
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // with point pool
        PointPool pool = new PointPool();

        // Get and use Point objects from the pool
        Point p11 = pool.getPoint(1, 2);
        Point p22 = pool.getPoint(3, 4);
        Point p33 = pool.getPoint(5, 6);

        System.out.println(p11);
        System.out.println(p22);
        System.out.println(p33);

        // Release Point objects back to the pool
        pool.releasePoint(p11);
        pool.releasePoint(p22);
        pool.releasePoint(p33);
    }
}
