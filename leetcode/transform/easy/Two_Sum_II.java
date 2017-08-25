package transform.easy;

public class Two_Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int point = 0;
        for (int i = numbers.length - 1; i > 0; i--) {
            for (; point < i; point++) {
                if (numbers[point] + numbers[i] == target) {
                    return new int[] { point + 1, i + 1 };
                } else if (numbers[point] + numbers[i] < target) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return null;
    }

}
