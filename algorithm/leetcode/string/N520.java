package string;

public class N520 {
    public boolean detectCapitalUse(String word) {
        if (word == null) return false;
        if (word.length() == 0 || word.length() == 1) return true;
        boolean firstLower = word.charAt(0) >= 97;
        if (firstLower) {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 97) return false;
            }
        } else {
            boolean secondLower = word.charAt(1) >= 97;
            if (secondLower) {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) < 97) return false;
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 97) return false;
                }
            }
        }
        return true;
    }
}
