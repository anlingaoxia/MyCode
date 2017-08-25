package transform.easy;

public class Length_of_Last_Word {
    public static int lengthOfLastWord(String s) {
        int count = 0;
        boolean has = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!has && s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == ' ') break;
            count++;
            has = true;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }

}
