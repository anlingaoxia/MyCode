package didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        for (String str : strs) {
            list.add(Integer.parseInt(str));
        }
        int thisSum = 0;
        int maxSum = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            thisSum += list.get(i);
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        System.out.println(maxSum);
    }
}
