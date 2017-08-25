package transform.easy;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
    //3ms
    public static List<String> fizzBuzz(int n) {
        List<String> sList = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                sList.add("FizzBuzz");
            } else if (i % 3 == 0){
                sList.add("Fizz");
            } else if(i % 5 == 0) {
                sList.add("Buzz");
            } else {
                sList.add(String.valueOf(i));
            }
        }
        return sList;
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fizzBuzz(n));
    }

}
