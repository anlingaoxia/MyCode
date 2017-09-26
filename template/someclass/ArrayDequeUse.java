package someclass;

import java.util.ArrayDeque;

public class ArrayDequeUse {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
        deque.add(6);
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pop());

    }
}
