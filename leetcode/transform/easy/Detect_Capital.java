package transform.easy;

public class Detect_Capital {
    public static boolean detectCapitalUse(String word) {
        if (word == null || word.equals("")) {
            return false;
        }
        if (word.length() < 2) {
            return true;
        }
        char[] cWord = word.toCharArray();
        boolean one = cWord[0] < 97 ? true : false;
        if (!one) {
            for (int i = 1; i < cWord.length; i++) {
                if (cWord[i] < 97) {
                    return false;
                }
            }
        } else {
            boolean two = cWord[1] < 97 ? true : false;
            if (two) {
                for (int i = 2; i < cWord.length; i++) {
                    if (cWord[i] > 96) {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < cWord.length; i++) {
                    if (cWord[i] < 97) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 'g';
        System.out.println(i);
        
        
        System.out.println(detectCapitalUse("ggg"));

    }

}
