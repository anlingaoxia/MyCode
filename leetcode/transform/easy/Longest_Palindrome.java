package transform.easy;

public class Longest_Palindrome {
    public static int longestPalindrome(String s) {
        int[] sHash = new int[123];
        for (int i = 0; i < s.length(); i++) {
            sHash[s.charAt(i)]++;
        }
        boolean hasSingle = false;
        int res = 0;
        for (int i = 0; i < 123; i++) {
            if (sHash[i] > 0) {
                if (sHash[i] % 2 == 0) {
                    res += sHash[i];
                } else {
                    hasSingle = true;
                    res += sHash[i] - 1;
                }
            }
        }
        return hasSingle ? res + 1 : res;

    }

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));

    }
}
