package transform.easy;

public class House_Robber {

    public static int rob2(int[] nums) {
        int lastRob = 0;
        int lastNot = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = lastRob;
            lastRob = Math.max(lastNot + nums[i], lastRob);
            lastNot = temp;
        }
        return Math.max(lastRob,lastNot);
    }

    public static int get(int[] nums, int sum, int n) {
        if (n >= nums.length) {
            return sum;
        }
        sum = sum + nums[n];
        System.out.println(n + "  " + sum);
        return Math.max(get(nums, sum, n + 2), get(nums, sum, n + 3));
    }

    public static void main(String[] args) {
        int[] nums = { 3,3,4 ,5};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
            System.out.println(prevNo + "      " + prevYes);
            System.out.println();
        }
        return Math.max(prevNo, prevYes);
    }
    
    public static void rob() {
        
    }
    
    

    public static int findMax(int[] nums, int start, int end) {
        int max = 0;
        if (start > end) {
            for (int i = start; i >= end; i--) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i = 0; i < 2; i++) {
            int sum = nums[i];
            for (int j = i; j <= nums.length - 3;) {
                if (j == nums.length - 3) {
                    sum += nums[j + 2];
                    break;
                } else if (j == nums.length - 4) {
                    sum = nums[j + 2] > nums[j + 3] ? sum + nums[j + 2] : sum + nums[j + 3];
                    break;
                }
                if (nums[j + 3] >= (nums[j + 2] + nums[j + 4])) {
                    sum += nums[j + 3];
                    j = j + 3;
                } else {
                    sum += nums[j + 2];
                    j = j + 2;
                }
            }
            System.out.println(sum);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
