package src;

public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglys = new int[index];
        uglys[0] = 1;
        int p = 1;
        int ugly2 = 0, ugly3 = 0, ugly5 = 0;
        while (p < index) {
            int min = min(uglys[ugly2] * 2, uglys[ugly3] * 3, uglys[ugly5] * 5);
            System.out.println("min:" + min);
            uglys[p++] = min;
            while (uglys[ugly2] * 2 <= min) {
                ugly2++;
            }
            while (uglys[ugly3] * 3 <= min) {
                ugly3++;
            }
            while (uglys[ugly5] * 5 <= min) {
                ugly5++;
            }
        }
        return uglys[uglys.length - 1];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
