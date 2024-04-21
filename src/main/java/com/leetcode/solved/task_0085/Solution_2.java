package com.leetcode.solved.task_0085;

import java.util.*;

public class Solution_2 {

    class Rectangle {
        int x1;
        int x2;
        int y1;

        Rectangle(int x1) {
            this.x1 = x1;
            this.y1 = 1;
        }

        Rectangle(int x1, int x2, int y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            return x1 == rectangle.x1 && x2 == rectangle.x2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, x2);
        }
    }

    public int maximalRectangle(char[][] matrix) {
        List<Rectangle> rectangles = new ArrayList<>();
        int result = 0;
        for (int y = 0; y < matrix.length; y++) {
            List<Rectangle> newRectangles = getRectangles(matrix[y]);
            result = merge(result, rectangles, newRectangles);
        }
        result = calcRectanglesArea(result, rectangles);
        return result;
    }

    private int merge(int result, List<Rectangle> rectangles, List<Rectangle> newRectangles) {

        Set<Rectangle> addNewRectangles = new HashSet<>();
        addNewRectangles.addAll(newRectangles);

        for (Rectangle rectangle: rectangles) {

            boolean calculated = false;

            for (int i = newRectangles.size() - 1; i >= 0; i--) {

                Rectangle newRectangle = newRectangles.get(i);

                if (areEqual(rectangle, newRectangle)) {
                    newRectangle.y1 = rectangle.y1 + 1;
                    calculated = true;
                    break;
                } else if (newRectangle.x1 <= rectangle.x1 && rectangle.x2 <= newRectangle.x2) {
                    // rectangle inside new rectangle
                    rectangle.y1++;
                    add(addNewRectangles, rectangle);
                    calculated = true;
                    break;
                } else if (rectangle.x1 <= newRectangle.x1 && newRectangle.x2 <= rectangle.x2) {
                    // new rectangle inside rectangle
                    result = calcRectangleArea(result, rectangle);
                    calculated = true;
                    add(addNewRectangles, new Rectangle(newRectangle.x1, newRectangle.x2, rectangle.y1 + 1));
                } else if (rectangle.x1 < newRectangle.x1 && newRectangle.x1 <= rectangle.x2) {
                    // rectangle has left part of new rectangle
                    result = calcRectangleArea(result, rectangle);
                    calculated = true;
                    add(addNewRectangles, new Rectangle(newRectangle.x1, rectangle.x2, rectangle.y1 + 1));
                } else if (newRectangle.x1 < rectangle.x1 && rectangle.x1 <= newRectangle.x2) {
                    // rectangle has right part of new rectangle
                    result = calcRectangleArea(result, rectangle);
                    calculated = true;
                    add(addNewRectangles, new Rectangle(rectangle.x1, newRectangle.x2, rectangle.y1 + 1));
                }
            }
            if (!calculated) {
                result = calcRectangleArea(result, rectangle);
            }
        }
        rectangles.clear();
        rectangles.addAll(addNewRectangles);
        return result;
    }

    private void add(Set<Rectangle> set, Rectangle item) {
        if (set.contains(item)) {
            for (Rectangle rectangle : set) {
                if (rectangle.equals(item)) {
                    rectangle.y1 = Math.max(rectangle.y1, item.y1);
                    break;
                }
            }
        } else {
            set.add(item);
        }
    }

    private boolean nothingCommon(Rectangle rect1, Rectangle rect2) {
        return rect1.x2 < rect2.x1 || rect2.x2 < rect1.x1;
    }

    private boolean areEqual(Rectangle rect1, Rectangle rect2) {
        return rect1.x1 == rect2.x1 && rect1.x2 == rect2.x2;
    }

    private int calcRectanglesArea(int result, List<Rectangle> rectangles) {
        for (Rectangle rectangle : rectangles) {
            result = calcRectangleArea(result, rectangle);
        }
        return result;
    }

    private int calcRectangleArea(int result, Rectangle rectangle) {
        int area = (rectangle.x2 - rectangle.x1 + 1) * rectangle.y1;
        if (result < area) {
            result = area;
        }
        return result;
    }

    private List<Rectangle> getRectangles(char[] inputArray) {
        List<Rectangle> rectangles = new ArrayList<>();
        Rectangle rectangle = null;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == '0' && rectangle != null) {
                rectangle.x2 = i - 1;
                rectangles.add(rectangle);
                rectangle = null;
            }
            if (inputArray[i] == '1' && rectangle == null) {
                rectangle = new Rectangle(i);
            }
        }
        if (rectangle != null) {
            rectangle.x2 = inputArray.length - 1;
            rectangles.add(rectangle);
        }
        return rectangles;
    }

}
