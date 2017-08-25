package string;

public class N058 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
            } else  {
                if (count != 0) last = count;
                count = 0;
            }
        }
        return count == 0 ? last : count;
    }
}
