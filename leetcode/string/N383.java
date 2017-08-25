package string;

public class N383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rHash = new int[128];
        int[] mHash = new int[128];
        for (int i = 0; i < ransomNote.length(); i++) {
            rHash[ransomNote.charAt(i)]++;
        }
        for (int j = 0; j < magazine.length(); j++) {
            mHash[magazine.charAt(j)]++;
        }
        for (int k = 0; k < 128; k++) {
            if (rHash[k] > mHash[k]) return false;
        }
        return true;
    }
}
