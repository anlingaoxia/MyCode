package src;

public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0];
        int thisSum = 0;
        for (int i : array) {
            thisSum += i;
            if (thisSum > maxSum) {
               maxSum = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
