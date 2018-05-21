package src;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int pushIndex = 0, popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (pushIndex < pushA.length || popIndex < popA.length) {
            if (stack.isEmpty() || popA[popIndex] != stack.peek()) {
                if (pushIndex == pushA.length) return false;
                stack.push(pushA[pushIndex++]);
            } else if (popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return true;
    }
}
