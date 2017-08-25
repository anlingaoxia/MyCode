package transform.easy2;

public class Third_Maximum_Number {
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int fMax = nums[0];
        int sMax = nums[0];
        int tMax = nums[0];
        boolean hasS = false;
        boolean hasT = false;
        for (int i = 1; i < nums.length; i++) {
            if (!hasS && nums[i] != fMax) {
                if (nums[i] > fMax) {
                    sMax = fMax;
                    fMax = nums[i];
                } else {
                    sMax = nums[i];
                }
                hasS = true;
                continue;
            } else if (!hasT && hasS && nums[i] != sMax && nums[i] != fMax) {
                if (nums[i] > fMax) {
                    tMax = sMax;
                    sMax = fMax;
                    fMax = nums[i];
                } else if (nums[i] > sMax && nums[i] < fMax) {
                    tMax = sMax;
                    sMax = nums[i];
                } else {
                    tMax = nums[i];
                }
                hasT = true;
                continue;
            }

            if (nums[i] > fMax) {
                tMax = sMax;
                sMax = fMax;
                fMax = nums[i];
            } else if (nums[i] < fMax && nums[i] > sMax) {
                tMax = sMax;
                sMax = nums[i];
            } else if (nums[i] < sMax && nums[i] > tMax) {
                tMax = nums[i];
            }
        }
        if (fMax != sMax && fMax != tMax && sMax != tMax) {
            return tMax;
        }
        return fMax;
    }

    public static void main(String[] args) {
        int[] input = { 2, 2, 3, 1 };
        System.out.println(thirdMax(input));
    }

}
