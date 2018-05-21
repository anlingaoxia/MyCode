package array;

public class N055 {
    public boolean canJump(int[] nums) {
        int n = 0;
        int max = nums[0];
        while (max >= n) {
            max = Math.max(max, n + nums[n++]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

    public static boolean canJump2(int[] nums) {
        int n = 0;
        int max = nums[0];
        while (max >= n) {
            System.out.println(n);
            max = Math.max(max, (n) + nums[n++]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60};
        get(array, 0);
        int n = 0;
        System.out.println("=====---");
        System.out.println(n + array[n++]);
        System.out.println(n);
        System.out.println("=====---");
    }

    public static void get(int[] nums, int n) {
        for (int i = 0; i < 3; i++) {
            System.out.println(n);
            System.out.println("MAX :" + Math.max(0, n++ + nums[n]));
            System.out.println(n);
            System.out.println("=====");
        }
    }
}
