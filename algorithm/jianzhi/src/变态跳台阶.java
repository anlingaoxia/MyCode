package src;

public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int record = 0;
        int sum = 3;

        for (int i = 3; i <= target; i++) {
            record = sum + 1;
            sum += record;
        }
        return record;
    }
}
