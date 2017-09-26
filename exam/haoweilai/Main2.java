package haoweilai;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String regex = sc.next();
    while (sc.hasNext()) {
        String str = sc.next();
        System.out.println(compare(regex.toCharArray(), str.toCharArray(), 0, 0));
    }
}

    public static boolean compare(char[] regex, char[] ctr, int p1, int p2) {
        if (p1 == regex.length && p2 < ctr.length) {
            return false;
        } else if (p1 < regex.length && p2 == ctr.length) {
            for (int i = p1; i < regex.length; i++) {
                if (regex[i] != '*') {
                    return false;
                }
            }
            return true;
        } else if (p1 == regex.length && p2 == ctr.length) {
            return true;
        } else {
            if (regex[p1] == '*') {
                return compare(regex, ctr, p1, p2 + 1) && compare(regex, ctr, p1 + 1, p2 + 1);
            } else if (regex[p1] == '?' || regex[p1] == ctr[p2]) {
                return compare(regex, ctr, p1 + 1, p2 + 1);
            } else {
                return false;
            }
        }
    }
}
