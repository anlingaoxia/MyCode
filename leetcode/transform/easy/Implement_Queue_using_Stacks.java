package transform.easy;

import java.util.LinkedList;
import java.util.Stack;

public class Implement_Queue_using_Stacks {
    static class MyQueue {
        LinkedList<Integer> list;

        public MyQueue() {
            list = new LinkedList<>();
        }

        // Push element x to the back of queue.
        public void push(int x) {
            list.add(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            list.removeFirst();
        }

        // Get the front element.
        public int peek() {
            return list.getFirst();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return list.size() == 0;
        }
    }

    public static void main(String[] args) {
        // MyQueue myQueue = new MyQueue();
        // myQueue.push(1);
        // myQueue.push(2);
        // System.out.println(myQueue.peek());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.peek());

    }

}
