package aiqiyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ctr = str.toCharArray();
        int R = 0, G = 0;
        for (int i = 0; i < ctr.length; i++) {
            if (ctr[i] == 'R') R++;
            else G++;
        }
        int Rl = 0, Gl = 0, minDiff = R;
        for (int i = 0; i < ctr.length; i++) {
            if (ctr[i] == 'G') Gl++;
            else Rl++;
            int diff = Gl + (R - Rl);
            if (diff < minDiff) minDiff = diff;
        }
        System.out.println(minDiff);
    }
}
