package transform.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class Implement_Stack_using_Queues {
    public static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new ArrayDeque<>();
        }

        // Push element x onto stack.
        public void push(int x) {
            queue.add(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            Queue<Integer> temp = new ArrayDeque<>();
            int n = queue.size();
            for (int i = 0; i < n - 1; i++) {
                temp.add(queue.poll());
            }
            queue = temp;
        }

        // Get the top element.
        public int top() {
            Queue<Integer> temp = new ArrayDeque<>();
            int n = queue.size();
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = queue.poll();
                temp.add(res);
            }
            queue = temp;
            return res;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack tMyStack = new MyStack();
        tMyStack.push(1);
        System.out.println(tMyStack.top());
//        tMyStack.pop();
//        System.out.println(tMyStack.top());
//        tMyStack.pop();
//        System.out.println(tMyStack.top());
//        tMyStack.empty();
//        tMyStack.pop();
//        tMyStack.empty();
    }

}
