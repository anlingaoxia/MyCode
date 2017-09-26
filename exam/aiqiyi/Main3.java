package aiqiyi;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ctr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (int i = 0; i < ctr.length; i++) {
            if (ctr[i] == '(') {
                stack.push('(');
                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                }
            } else {
                stack.pop();
            }
        }
        System.out.println(maxDepth);
    }
}
