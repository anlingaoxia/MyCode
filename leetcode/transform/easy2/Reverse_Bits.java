package transform.easy2;

public class Reverse_Bits {
    public static int reverseBits(int n) {
        int out = 0;
        for (int i = 0; i < 32; i++) {
            out <<= 1;
            if ((n & 1) == 1) out += 1;
            n >>>= 1;
        }

        return out;
    }

    public static void main(String[] args) {
         System.out.println(reverseBits(43261596));
//        System.out.println(43261596 >>> 1);
    }
}
