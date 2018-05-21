package src;

public class 矩形覆盖 {
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target <= 2) {
            return target;
        }
        int n1 = 1;
        int n2 = 2;
        int n3 = 0;
        for (int i = 0; i < target - 2; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}
