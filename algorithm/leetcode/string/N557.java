package string;

public class N557 {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] noSpace = s.split(" ");
        if (noSpace.length == 0) return "";
        StringBuilder sb = new StringBuilder("");
        for (String t : noSpace) {
            System.out.println(t);
            String reverse = reverseOne(t);
            System.out.println(reverse);
            sb.append(reverse).append(" ");
            System.out.println(sb.toString());
            System.out.println("=====");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String reverseOne(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }


}
