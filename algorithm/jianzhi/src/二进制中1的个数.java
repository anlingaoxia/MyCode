package src;

public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int c = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        c = (c & 0x33333333) + ((c >> 2) & 0x33333333);
        c = (c & 0x0F0F0F0F) + ((c >> 4) & 0x0F0F0F0F);
        c = (c & 0x00FF00FF) + ((c >> 8) & 0x00FF00FF);
        c = (c & 0x0000FFFF) + ((c >> 16) & 0x0000FFFF);
        return c;
    }


    public int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n- 1);
            count++;
        }
        return count;
    }

}
