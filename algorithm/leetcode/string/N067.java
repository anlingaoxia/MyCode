package string;

public class N067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        int up = 0, aN = 0, bN = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            aN = bN = 0;
            if (i >= 0) aN = a.charAt(i) - 48;
            if (j >= 0) bN = b.charAt(j) - 48;
            int cN = aN + bN + up;
            if (cN >= 2) {
                cN -= 2;
                up = 1;
            } else up = 0;
            sb = sb.insert(0, cN);
        }
        if (up > 0) sb = sb.insert(0, up);
        return sb.toString();
    }

    public static void main(String[] args) {
        char a = '0';
        System.out.println((int) a);
    }
}
