package transform.easy2;

import java.util.Arrays;

public class Reverse_Integer {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;

    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int point = k % length;
        int[] temp = new int[point];
        for (int i = 0; i < point; i++) {
            temp[i] = nums[length - point + i];
        }
        for (int i = length - 1; i >= point; i--) {
            nums[i] = nums[i - point];
        }
        for (int i = 0; i < point; i++) {
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3,4,5 };
        rotate(input1, 3);
        System.out.println(Arrays.toString(input1));
    }

    public static void change(A a1, A a2) {
        a1.up();
        a2.up();
    }

    public static void get(int[] input1, int[] input2) {

    }

}

class A {
    int x;

    A(int x) {
        this.x = x;
    }

    void up() {
        x++;
    }
}
