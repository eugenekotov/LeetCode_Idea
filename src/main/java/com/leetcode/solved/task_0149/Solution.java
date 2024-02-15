package com.leetcode.solved.task_0149;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxPoints(int[][] points) {
        UniquePoints uniquePoints = getUniquePoints(points);
        if (uniquePoints.counts.size() < 3) {
            if (uniquePoints.counts.size() == 0) {
                return 0;
            }
            int result = uniquePoints.counts.get(0);
            if (uniquePoints.counts.size() == 2) {
                result = result + uniquePoints.counts.get(1);
            }
            return result;
        }
        // мы знаем, что все уникально
        int max = 0;
        for (int i = 0; i < uniquePoints.points.size() - 1; i++) {
            Point point1 = uniquePoints.points.get(i);
            for (int j = i + 1; j < uniquePoints.points.size(); j++) {
                Point point2 = uniquePoints.points.get(j);
                int tempMax = uniquePoints.counts.get(i) + uniquePoints.counts.get(j);
                for (int k = j + 1; k < uniquePoints.points.size(); k++) {
                    Point point3 = uniquePoints.points.get(k);
                    if (isLine(point1, point2, point3)) {
                        tempMax = tempMax + uniquePoints.counts.get(k);
                    }
                }
                if (max < tempMax) {
                    max = tempMax;
                }
            }
        }
        return max;
    }

    private static boolean isLine(Point point1, Point point2, Point point3) {
        int x1 = point1.x - point2.x;
        int y1 = point1.y - point2.y;
        int x2 = point1.x - point3.x;
        int y2 = point1.y - point3.y;
        if (y1 == 0 && y2 == 0) {
            return true;
        }
        if (y1 * y2 == 0) {
            return false;
        }
        double k1 = ((double) x1) / ((double) y1);
        double k2 = ((double) x2) / ((double) y2);
        return k1 == k2;
    }

    private static UniquePoints getUniquePoints(int[][] points) {
        UniquePoints result = new UniquePoints();
        for (int i = 0; i < points.length; i++) {
            Point point = createPoint(points[i]);
            if (point != null) {
                int index = result.points.lastIndexOf(point);
                if (index == -1) {
                    result.points.add(point);
                    result.counts.add(1);
                } else {
                    result.counts.set(index, result.counts.get(index) + 1);
                }
            }
        }
        return result;
    }

    private static Point createPoint(int[] point) {
        if (point.length == 0) {
            return null;
        }
        return new Point(point);
    }

    private static class Point {
        int x;
        int y;

        public Point(int[] point) {
            x = point[0];
            y = point[1];
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }

    private static class UniquePoints {
        List<Point> points = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
    }
}
