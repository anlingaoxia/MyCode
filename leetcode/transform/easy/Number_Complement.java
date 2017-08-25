package transform.easy;

public class Number_Complement {
    public static int findComplement(int num) {
        if (num <= 0) {
            return -1;
        }

        int n = 0;
        int all = 0;
        int count = num;

        while (count > 0) {
            n++;
            all = 1 << n;
            count >>>= 1;
        }
        return all - 1 - num;
    }

    public int bg(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

}
