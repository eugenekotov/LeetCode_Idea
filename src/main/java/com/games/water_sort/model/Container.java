package com.games.water_sort.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Container implements Cloneable {

    public static final int MAX_SIZE = 4;
    private boolean resolved = false;

    private final Stack<Color> stack = new Stack<>();
    private List<Color> list;

    public Container() {
        afterChange();
    }

    public Container(Color c1, Color c2, Color c3, Color c4) {
        this.stack.push(c1);
        this.stack.push(c2);
        this.stack.push(c3);
        this.stack.push(c4);
        afterChange();
    }

    private void afterChange() {
        generateList();
        checkResolved();
    }

    private void generateList() {
        list = new ArrayList<>(stack);
    }

    public Color peek() {
        return stack.peek();
    }

    public void push(Color color) {
        stack.push(color);
        afterChange();
    }

    public Color pop() {
        Color result = stack.pop();
        afterChange();
        return result;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isResolved() {
        return resolved;
    }

    private void checkResolved() {
        if (stack.size() != MAX_SIZE) {
            resolved = false;
        } else {
            resolved = stack.stream().allMatch(color -> color == stack.peek());
        }
    }

    public boolean hasOnlyThreeOfOneColor() {
        return list.size() == 3 && list.get(0) == list.get(1) && list.get(0) == list.get(2);
    }

    public boolean hasOnlyTwoOfOneColor() {
        return list.size() == 2 && list.get(0) == list.get(1);
    }

    public List<Color> getColorsList() {
        return list;
    }

    public Container clone() {
        Container newContainer;
        try {
            newContainer = (Container) super.clone();
        } catch (CloneNotSupportedException e) {
            newContainer = new Container();
        }
        stack.forEach(newContainer::push);
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
        List<Color> list2 = container.getColorsList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list2.get(i)) {
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
