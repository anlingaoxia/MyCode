package transform.easy;

public class Number_of_Segments_in_a_String {
    public static int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int last = s.charAt(0);
        int count = 0;
        if (last != 32) {
            count++;
        }
        for (int i = 1; i < s.length(); i++) {
            int now = s.charAt(i);
            if (now != 32 && last == 32) {
                count++;
            }
            last = now;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        System.out.println(countSegments(s));
    }

}
