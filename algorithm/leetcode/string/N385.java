package string;

import java.util.List;
import java.util.Stack;

//NOT TODO
public class N385 {
    static int p = 0;

    public NestedInteger deserialize(String s) {
        return getNestedInteger(s.toCharArray(), new Stack<Character>(), new NestedInteger());
    }

    public NestedInteger getInteger(Stack<Character> stack) {
        int integer = 0, pow = 0;
        while (stack.peek() != '[') {
            char c = stack.pop();
            if (c == '-') {
                integer = -integer;
            } else {
                integer += Math.pow(c - 48, pow++);
            }
        }
        return new NestedInteger(integer);
    }


    public NestedInteger getNestedInteger(char[] ctr, Stack<Character> stack, NestedInteger thisInteger) {
        while (p < ctr.length) {
            if (ctr[p] == '-' || (ctr[p] >= 48 && ctr[p] <= 57)) {
                stack.push(ctr[p++]);
            } else if (ctr[p] == '[') {
                stack.push(ctr[p++]);
                getNestedInteger(ctr, stack, new NestedInteger());
            } else if (ctr[p] == ',') {
                thisInteger.add(getInteger(stack));
                p++;
            } else {
                thisInteger.add(getInteger(stack));
                stack.pop();
                p++;
                return thisInteger;
            }
        }
        return getInteger(stack);
    }

}

class NestedInteger {
    public NestedInteger() {

    }

    public NestedInteger(int value) {

    }

    public boolean isInteger() {
        return false;
    }

    public Integer getInteger() {
        return null;
    }

    public void setInteger(int value) {
    }

    public void add(NestedInteger ni) {
    }

    public List<NestedInteger> getList() {
        return null;
    }
}
