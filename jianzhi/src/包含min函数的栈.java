package src;

import java.util.Stack;

public class 包含min函数的栈 {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty() || node <= min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

}
