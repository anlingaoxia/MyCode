package string;

import java.util.Stack;

public class N020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(' || t == '[' || t == '{') stack.push(t);
            else if (stack.isEmpty()) return false;
            else if (t == ')' && stack.pop() != '(') return false;
            else if (t == ']' && stack.pop() != '[') return false;
            else if (t == '}' && stack.pop() != '{') return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                int compare = stack.peek() + c;
                if (compare == 81 || compare == 184 || compare == 248) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid2(""));
    }

}
