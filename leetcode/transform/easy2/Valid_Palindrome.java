package transform.easy2;

public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        char[] sC = s.toCharArray();
        for (int i = 0, j = sC.length - 1; i <= j;) {
            while (i <= j) {
                if (!isHCharacter(sC[i]) && !isLCharacter(sC[i]) && !isNumber(sC[i])) i++;
                else break;
            }
            while (i <= j) {
                if (!isHCharacter(sC[j]) && !isLCharacter(sC[j]) && !isNumber(sC[j])) j--;
                else break;
            }
            if (i > j) return true;
            if ((isNumber(sC[i]) || isNumber(sC[j])) && sC[i] != sC[j]) return false;
            else if (isHCharacter(sC[i]) && isHCharacter(sC[j]) && sC[i] != sC[j]) return false;
            else if (isLCharacter(sC[i]) && isLCharacter(sC[j]) && sC[i] != sC[j]) return false;
            else if (isHCharacter(sC[i]) && isLCharacter(sC[j]) && sC[i] != sC[j] - 32) return false;
            else if (isLCharacter(sC[i]) && isHCharacter(sC[j]) && sC[i] != sC[j] + 32) return false;

            i++;
            j--;
        }
        return true;
    }

    public static boolean isLCharacter(char c) {
        return c >= 97 && c <= 122 ? true : false;
    }

    public static boolean isHCharacter(char c) {
        return c >= 65 && c <= 90 ? true : false;
    }

    public static boolean isNumber(char c) {
        return c >= 48 && c <= 57 ? true : false;
    }

    public static void main(String[] args) {
        String input = "ab2a";
        System.out.println(isPalindrome(input));

    }

}
