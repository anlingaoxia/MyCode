package transform.easy;

public class Repeated_Substring_Pattern {
    public static boolean repeatedSubstringPattern(String str) {
        for (int i = 2; i <= str.length(); i++) {
            if (str.length() % i == 0) {
                String toBeCompared = str.substring(0, str.length() / i);
                int length = toBeCompared.length();
                boolean equal = true;
                for (int j = 1; j < i; j++) {
                    String comparator = str.substring(length * j, length * (j + 1));
                    if(!toBeCompared.equals(comparator)) {
                        equal = false;
                    }
                }
                if(equal) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String s = "abcdabcdabcde";
        System.out.println(repeatedSubstringPattern(s));
    }

}
