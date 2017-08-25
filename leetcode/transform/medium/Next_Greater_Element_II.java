package transform.medium;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_II {
    public static int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        get(nums, res, 0, 0);
        return res;
    }

    public static void get(int[] nums, int[] res, int target, int flag) {
        if (target == nums.length) return;
        for (int j = target + 1;; j++) {
            if (j == nums.length) j = 0;
            if (j == flag && nums[j] <= nums[target]) {
                flag = target;
                res[target] = -1;
                break;
            }
            if (nums[j] > nums[target]) {
                res[target] = nums[j];
                flag = j;
                break;
            }
        }
        get(nums, res, target + 1, flag);
    }
    
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            System.out.println("num:" + num);
            System.out.println("OUTstack:" + stack);
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                System.out.println("stack:" + stack);
                next[stack.pop()] = num;
            }
            if (i < n) stack.push(i);
            System.out.println("======");
        }   
        
        
        System.out.println("LAST:" + stack);
        return next;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2,2, 1 };
        System.out.println(Arrays.toString(get(nums)));
    }
    
    
    
    public static int[] get(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < nums.length * 2; i++) {
            while(! stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            if(i < nums.length) stack.push(i);
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
