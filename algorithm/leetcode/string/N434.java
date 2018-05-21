package string;

public class N434 {
    public static int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        boolean start = false;
        for (int i = 0; i < s.length(); i++) {
            if (!start && s.charAt(i) != ' ') {
                count++;
                start = true;
            }
            else if (s.charAt(i) == ' ') start = false;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
