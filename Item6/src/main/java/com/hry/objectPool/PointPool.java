package com.hry.objectPool;

import java.util.Stack;

public class PointPool {
    private Stack<Point> pool = new Stack<>();
    private static final int MAX_POOL_SIZE = 10;

    public Point getPoint(int x, int y) {
        if (pool.isEmpty()) {
            return new Point(x, y);
        }
        Point p = pool.pop();
        // Simulate setting new coordinates (not really practical here)
        // Ideally, the Point class would have a method to reset its coordinates
        return new Point(x, y);
    }

    public void releasePoint(Point p) {
        if (pool.size() < MAX_POOL_SIZE) {
            pool.push(p);
        }
    }
}
