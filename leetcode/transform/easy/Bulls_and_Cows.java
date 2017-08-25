package transform.easy;

public class Bulls_and_Cows {
    public static String getHint2(String secret, String guess) {
        int[] bHash = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) bull++;
            else bHash[secret.charAt(i) - 48]++;
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i)) {
                if (bHash[guess.charAt(i) - 48] > 0) {
                    cow++;
                    bHash[guess.charAt(i) - 48]--;
                }
            }
        }
        
        return bull + "A" + cow + "B";
    }
    
    public static String getHint(String secret, String guess) {
        int[] bHash = new int[10];
        int[] cHash = new int[10];
        int[] rHash = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            bHash[secret.charAt(i) - 48]++;
            cHash[guess.charAt(i) - 48]++;
        }

        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else if (rHash[guess.charAt(i) - 48] < bHash[guess.charAt(i) - 48]) {
                rHash[guess.charAt(i) - 48]++;
                cow++;
            }
        }

        return bull + "A" + cow + "B";
    }
    public void getInt() {
        
        
        
        
        
    }
    
    
    

    public static void main(String[] args) {
        String secret = "1122";
        String guess = "1222";
        System.out.println(getHint(secret, guess));
        System.out.println(getHint2(secret, guess));
    }
}
