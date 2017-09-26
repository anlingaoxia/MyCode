package 算法题;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class 从字符串中删除子串 {
    public static void delete(String str, String subStr) {
        if (str == null || subStr == null || str.length() == 0 || subStr.length() == 0 || str.length() < subStr.length()) {
            return;
        }
        Stack<Character> ctr = new Stack<>();
        Stack<Character> save = new Stack<>();
        Queue<Character> del = new ArrayDeque<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            ctr.push(str.charAt(i));
        }

        int pSubStr = 0;
        boolean last = false;

        while (!ctr.isEmpty()) {
            if (!last) {
                if (ctr.peek() == subStr.charAt(pSubStr)) {
                    del.add(ctr.pop());
                    pSubStr++;
                    last = true;
                } else {
                    save.push(ctr.pop());
                }
            } else {
                if (ctr.peek() == subStr.charAt(pSubStr)) {
                    del.add(ctr.pop());
                    pSubStr++;
                    if (pSubStr == subStr.length()) {
                        del.clear();
                        mix(ctr, save);
                        pSubStr = 0;
                        last = false;
                    }
                } else {
                    mix(save, del);
                    pSubStr = 0;
                    last = false;
                }
            }
        }

        char[] newStr = new char[save.size()];
        int p = newStr.length - 1;
        while (!save.isEmpty()) {
            newStr[p--] = save.pop();
        }
    }


    public static void mix(Stack<Character> stack1, Stack<Character> stack2) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public static void mix(Stack<Character> stack, Queue<Character> queue) {
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
    }
}
