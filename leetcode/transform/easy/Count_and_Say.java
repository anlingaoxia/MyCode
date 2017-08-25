package transform.easy;

public class Count_and_Say {
    public static String countAndSay2(int n) {
        String in = String.valueOf(1);
        for (int k = 1; k < n; k++) {
            String out = "";
            char last = in.charAt(0);
            int count = 1;
            for (int i = 1; i < in.length(); i++) {
                if (last == in.charAt(i)) {
                    count++;
                } else {
                    out = out + String.valueOf(count) + String.valueOf(last);
                    last = in.charAt(i);
                    count = 1;
                }
            }
            out = out + String.valueOf(count) + String.valueOf(last);
            in = out;
        }
        return in;
    }

    public static String countAndSay(int n) {
        int in = 1;
        String out = "1";
        for (int i = 1; i < n; i++) {
            out = "";
            int last = in % 10;
            int count = 1;
            while ((in = in / 10) != 0) {
                if (last == in % 10) {
                    count++;
                } else {
                    out = String.valueOf(count) + String.valueOf(last) + out;
                    last = in % 10;
                    count = 1;
                }
            }
            out = String.valueOf(count) + String.valueOf(last) + out;
            in = Integer.parseInt(out);
        }
        return out;
    }

    public static String get(String s) {
        char last = s.charAt(0);
        int count = 1;
        String out = "";
        for (int i = 1; i < s.length(); i++) {
            if (last == s.charAt(i)) {
                count++;
            } else {
                out = String.valueOf(count) + String.valueOf(last);
                last = s.charAt(i);
                count = 1;
            }
        }
        out = out + String.valueOf(count) + String.valueOf(last);
        return out;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            System.out.println(countAndSay(i));
        }
    }

}
