package transform.easy2;

public class Add_Binary {
    public String addBinary(String a, String b) {
        char a0 = a.charAt(0);
        char b0 = b.charAt(0);
        boolean aP = true;
        boolean bP = true;
        if (a0 == 43) a = a.substring(1);
        else if (a0 == 45) {
            a = a.substring(1);
            aP = false;
        }
        if (b0 == 43) b = b.substring(1);
        else if (b0 == 45) {
            b = b.substring(1);
            bP = false;
        }
        String c = "";
        int up = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int aN = 0;
            int bN = 0;
            if (i >= 0) aN = a.charAt(i) - 48;
            if (j >= 0) bN = b.charAt(j) - 48;

            int cN = aN + bN + up;
            if (cN >= 2) {
                cN -= 2;
                up = 1;
            } else {
                up = 0;
            }
            c = cN + c;
        }
        if (up > 0) {
            c = up + c;
        }

        return c;
    }
}
