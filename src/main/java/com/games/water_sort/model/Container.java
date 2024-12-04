package com.games.water_sort.model;

import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Container {

    public static final int MAX_SIZE = 4;
    private boolean resolved = false;
    private boolean hasOnlyThreeColor = false;

    private final Stack<Color> stack = new Stack<>();

    public Container() {
    }

    public Container(Color c1, Color c2, Color c3, Color c4) {
        this.stack.push(c1);
        this.stack.push(c2);
        this.stack.push(c3);
        this.stack.push(c4);
        checkResolved();
    }

    public Color peek() {
        return stack.peek();
    }

    public void push(Color color) {
        if (stack.size() == MAX_SIZE) {
            throw new RuntimeException("Push too many colors");
        }
        stack.push(color);
        checkResolved();
    }

    public Color pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isResolved() {
        return resolved;
    }

    private void checkResolved() {
        checkOnlyThreeOneColor();
        if (stack.size() != MAX_SIZE) {
            resolved = false;
        } else {
            resolved = stack.stream().allMatch(color -> color == stack.peek());
//            if (resolved) {
//                System.out.println("Resolved container");
//            }
        }
    }

    private void checkOnlyThreeOneColor() {
        if (stack.size() != 3) {
            hasOnlyThreeColor = false;
        } else {
            hasOnlyThreeColor = stack.stream().allMatch(color -> color == stack.peek());
//            if (hasOnlyThreeColor) {
//                System.out.println("hasOneColor");
//            }
        }
    }

    public boolean isHasOnlyThreeColor() {
        return hasOnlyThreeColor;
    }

    public void setHasOnlyThreeColor(boolean hasOnlyThreeColor) {
        this.hasOnlyThreeColor = hasOnlyThreeColor;
    }

    public List<Color> getColors() {
        return stack.stream().collect(Collectors.toList());
    }

    @Override
    public Container clone() {
        Container newContainer = new Container();
        stack.stream().forEach(color -> newContainer.push(color));
        return newContainer;
    }

    public boolean isFull() {
        return stack.size() == MAX_SIZE;
    }

    public int size() {
        return stack.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        if (size() != container.size()) {
            return false;
        }
        List<Color> list1 = getColors();
        List<Color> list2 = container.getColors();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stack);
    }
}
