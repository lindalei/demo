package com.linda.demo.algocasts;

import java.util.Stack;

public class minStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= getMin()) {
            min.push(x);
        }
    }

    public void pop() {
        stack.pop();
        if (stack.peek() == getMin()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min.peek();
    }

}
