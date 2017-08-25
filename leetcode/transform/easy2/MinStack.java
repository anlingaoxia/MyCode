package transform.easy2;

import java.util.Iterator;
import java.util.LinkedList;

public class MinStack {

    /** initialize your data structure here. */
    LinkedList<Integer> stack;
    int min;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) min = x;
        else if (x < min) min = x;
        stack.add(x);
    }

    public void pop() {
        int pop = stack.removeLast();
        if (!stack.isEmpty() && pop == this.min) {
            int min = stack.getFirst();
            for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext();) {
                int temp = iterator.next();
                if (temp <= min) {
                    min = temp;
                }
            }
            this.min = min;
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
